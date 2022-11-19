package com.bdqn;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.Book;
import com.bdqn.mapper.BookMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class Springboot18EsApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RestHighLevelClient highLevelClient;


/*    @BeforeEach
    void setUp() {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        highLevelClient = new RestHighLevelClient(builder);
    }*/

    @AfterEach
    void tearDown() throws IOException {
        /*关闭*/
        highLevelClient.close();
    }

    @Test
    void testAll() {
        System.out.println(bookMapper.selectById(2));
    }


    /**
     * 创建ES索引
     */
    @Test
    void testCreateIndex() throws IOException {
        /*创建索引*/
        CreateIndexRequest request = new CreateIndexRequest("books");
        highLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 创建分词器
     */
    @Test
    void testCreateIndexByIk() throws IOException {
        /*创建索引*/
        CreateIndexRequest request = new CreateIndexRequest("books");
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("id");
                {
                    builder.field("type", "keyword");
                }
                builder.endObject();

                builder.startObject("name");
                {
                    builder.field("type", "text")
                            //插入时分词
                            .field("analyzer", "ik_max_word")
                            //搜索时分词
                            .field("copy_to", "all");
                }
                builder.endObject();

                builder.startObject("type");
                {
                    builder.field("type", "keyword");
                }
                builder.endObject();
                builder.startObject("description");
                {
                    builder.field("type", "text")
                            .field("analyzer","ik_max_word")
                            .field("copy_to", "all");
                }
                builder.endObject();
                builder.startObject("all");
                {
                    builder.field("type", "text")
                            //插入时分词
                            .field("analyzer", "ik_max_word")
                            //搜索时分词
                            .field("search_analyzer", "ik_smart");
                }
                builder.endObject();
            }
            builder.endObject();
        }
        builder.endObject();
        request.mapping(builder);
        highLevelClient.indices().create(request, RequestOptions.DEFAULT);
    }

    /**
     * 添加文档
     */
    @Test
    void testCreateDoc() throws IOException {
        IndexRequest request = new IndexRequest("books").id("1");
        Book book = bookMapper.selectById(2);
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        IndexResponse index = highLevelClient.index(request, RequestOptions.DEFAULT);
    }

    /**
     * 批量插入
     *
     * @throws IOException
     */
    @Test
    void testCreateDocAll() throws IOException {
        List<Book> books = bookMapper.selectList(null);
/*        IndexRequest request=new IndexRequest("books").id(books);
        String json = JSON.toJSONString(books);
        request.source(json,XContentType.JSON);
        IndexResponse index = highLevelClient.index(request, RequestOptions.DEFAULT);*/

        BulkRequest request = new BulkRequest();

        StringBuilder sb = null;
        for (Book book : books) {
            System.out.println(book.getId());
            sb = new StringBuilder();
            IndexRequest indexRequest = new IndexRequest("books").id(book.getId());
            sb.append(JSON.toJSONString(book));
            indexRequest.source(sb.toString(), XContentType.JSON);
            request.add(indexRequest);
        }
        highLevelClient.bulk(request, RequestOptions.DEFAULT);
    }

    /**
     * 查询单个数据
     */
    @Test
    void testFindID() throws IOException {
        GetRequest request = new GetRequest("books", "1");
        GetResponse response = highLevelClient.get(request, RequestOptions.DEFAULT);
        String sourceAsString = response.getSourceAsString();
        System.out.println("sourceAsString = " + sourceAsString);

    }

    /**
     * 按条件查询
     */
    @Test
    void testSearch() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SearchRequest request = new SearchRequest("books");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all", "测试"));
        request.source(builder);
        SearchResponse search = highLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            //Book book = JSON.parseObject(sourceAsString, Book.class);
            //System.out.println(book);
            Book book = objectMapper.readValue(sourceAsString, Book.class);
            System.out.println("book = " + book);
        }
    }
}
