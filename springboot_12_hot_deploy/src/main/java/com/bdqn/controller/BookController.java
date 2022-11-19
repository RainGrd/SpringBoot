package com.bdqn.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bdqn.Constants.ConstantEnum;
import com.bdqn.Vo.PageBean;
import com.bdqn.entity.Book;
import com.bdqn.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author RanGrd
 * @since 2022-10-01
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/queryBookAll.do")
    @ResponseBody
    public String queryBookAll() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bookService.queryBookList(null));
    }


//    @GetMapping("/queryBookPage.do")
    @ResponseBody
    public String queryBookPage(@RequestParam Map<String, Object> hashMap) throws JsonProcessingException {
        Map<String, String> map = hashMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (String) e.getValue()));
        //System.out.println("test hot deploy...");
        System.out.println("test hot deploy...");
        IPage<Book> bookIPage = bookService.queryBookPage(map);
        return objectMapper.writeValueAsString(bookIPage);
    }


    /**
     * 保存方法
     */
    @PostMapping("/saveBook.do")
    @ResponseBody
    public Object saveBook(@RequestBody Book book) throws JsonProcessingException {
        System.out.println(book);
        PageBean<Book> pageBean = new PageBean<>();
        try {
            int save = bookService.save(book);
            if (save > 0) {
                pageBean.setCode(ConstantEnum.PAGE_BEAN_SUCCESS_CODE.getCode());
            } else {
                pageBean.setCode(ConstantEnum.PAGE_BEAN_FAIL_CODE.getCode());
                pageBean.setMessage("修改错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageBean.setCode(ConstantEnum.PAGE_BEAN_FAIL_CODE.getCode());
            pageBean.setMessage("系统忙！正在维护中！");
        }
        return pageBean;
    }

    /**
     * 修改方法
     */
    @PutMapping("/updateBook.do")
    @ResponseBody
    public Object updateBook(@RequestBody Book book) {

        PageBean<Book> pageBean = new PageBean<>();
        try {
            int save = bookService.update(book);
            if (save > 0) {
                pageBean.setCode(ConstantEnum.PAGE_BEAN_SUCCESS_CODE.getCode());
                return objectMapper.writeValueAsString(pageBean);
            } else {
                pageBean.setCode(ConstantEnum.PAGE_BEAN_FAIL_CODE.getCode());
                pageBean.setMessage("修改错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageBean.setCode(ConstantEnum.PAGE_BEAN_FAIL_CODE.getCode());
            pageBean.setMessage("系统忙！正在维护中！");
        }
        return pageBean;
    }

    /**
     * 根据id查询
     */
    @GetMapping("/queryById.do/{id}")
    @ResponseBody
    public String queryById(@PathVariable Long id) throws JsonProcessingException {
        Book book = bookService.queryBookById(id);
        System.out.println(book);
        return objectMapper.writeValueAsString(book);
    }


    /**
     * 删除方法
     */
    @DeleteMapping("/deleteBook.do/{id}")
    @ResponseBody
    public Object deleteBook(@PathVariable Long id) throws JsonProcessingException {
        PageBean<Book> pageBean = new PageBean<>();
        try {
            int save = bookService.deleteById(id);
            if (save > 0) {
                pageBean.setCode(ConstantEnum.PAGE_BEAN_SUCCESS_CODE.getCode());
                return objectMapper.writeValueAsString(pageBean);
            } else {
                pageBean.setCode(ConstantEnum.PAGE_BEAN_FAIL_CODE.getCode());
                pageBean.setMessage("删除错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageBean.setCode(ConstantEnum.PAGE_BEAN_FAIL_CODE.ordinal());
            pageBean.setMessage("系统忙！正在维护中！");
        }
        return pageBean;
    }
}
