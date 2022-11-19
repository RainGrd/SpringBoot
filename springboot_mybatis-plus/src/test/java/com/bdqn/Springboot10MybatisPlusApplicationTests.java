package com.bdqn;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.mapper.UserMapper;
import com.bdqn.pojo.User;
import com.bdqn.pojo.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Springboot10MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testDeleteById() {
        int byId = userMapper.deleteById(2L);
        System.out.println(byId);
    }

    @Test
    void testUpdate() {
/*        User user = new User();
        user.setId(1L);
        user.setAge(20);
        user.setPassword("drg1224605");
        user.setName("段荣贵");
        user.setVersion(1);
        userMapper.updateById(user);*/
/*        //1.先通过要修改的数据id将当前数据查询出来
        User user = userMapper.selectById(1L);
        //将要修改的属性逐一设置进去
        user.setName("drg");
        userMapper.updateById(user);*/

        //1.先通过要修改的数据id将当前数据查询出来
        User user1 = userMapper.selectById(1L);
        //1.先通过要修改的数据id将当前数据查询出来
        User user2 = userMapper.selectById(3L);
        //将要修改的属性逐一设置进去
        user1.setName("drg123");
        userMapper.updateById(user1); //version=3


        //将要修改的属性逐一设置进去
        user2.setName("drg");
        userMapper.updateById(user2);

    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    @Test
    void testDelete() {
/*        List<Long> list=new ArrayList<>();
        list.add(666L);
        list.add(667L);
        list.add(5L);
        userMapper.deleteBatchIds(list);*/

        //userMapper.selectBatchIds()
/*        List<Long> list=new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(4L);
        userMapper.selectBatchIds(list);*/
        userMapper.deleteById(3L);
    }

    @Test
    void testSave() {
        User user = new User();
        //user.setId(667L);
        user.setName("黑马程序员");
        user.setAge(18);
        user.setTel("1853461145");
        user.setPassword("666");
        userMapper.insert(user);
    }

    @Test
    void testGetAll() {
        /*按条件查询一*/
/*
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.lt("age",18);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println("users = " + users);
*/
        /*按条件查询二*/
/*
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.lambda().lt(User::getAge, 18);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println("users = " + users);
*/

        /*按条件查询三*/
/*        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //userLambdaQueryWrapper.lt(User::getAge,10).ge(User::getAge,18);
        userLambdaQueryWrapper.lt(User::getAge,10).or().ge(User::getAge,18);
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println(users);*/
/*        UserQuery userQuery = new UserQuery();
        //userQuery.setAge(1);
        userQuery.setAge2(18);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //userLambdaQueryWrapper.lt(User::getAge,10).ge(User::getAge,18);
        userLambdaQueryWrapper.lt(null != userQuery.getAge2(), User::getAge, userQuery.getAge2());
        userLambdaQueryWrapper.lt(null != userQuery.getAge(), User::getAge, userQuery.getAge());

*//*        if (userQuery.getAge()!=null){
            userLambdaQueryWrapper.gt(User::getAge, userQuery.getAge());
        }*//*
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println(users);*/
        /*查询投影*/
        //LambdaQueryWrapper<User> userLambdaQueryWrapper=new LambdaQueryWrapper<>();
        //QueryWrapper<User> userLambdaQueryWrapper = new QueryWrapper<>();
        //userLambdaQueryWrapper.select(User::getId,User::getName,User::getAge);
        //userLambdaQueryWrapper.select("count(*) as count,tel");
        //userLambdaQueryWrapper.groupBy("tel");
        //List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        //System.out.println(users);
        //List<Map<String, Object>> maps = userMapper.selectMaps(userLambdaQueryWrapper);
        //System.out.println(maps);
        /*条件查询*/
        //LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        /*等于=*/
        //lambdaQueryWrapper.eq(User::getName,"yangge").eq(User::getPassword,"666");
        //User user = userMapper.selectOne(lambdaQueryWrapper);
        //System.out.println(user);

/*        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        *//*范围查询 lt le gt ge eq between *//*
        userLambdaQueryWrapper.between(User::getAge,1,18);
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println(users);*/
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        /*范围查询 lt le gt ge eq between */
        userLambdaQueryWrapper.likeRight(User::getName,"d");
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        System.out.println(users);
    }

    @Test
    void testPage() {
        Page<User> page = new Page(2, 2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println(userIPage.getPages());
        System.out.println(userIPage.getTotal());
        System.out.println(userIPage.getCurrent());
        System.out.println(userIPage.getRecords());
        System.out.println(userIPage.getSize());
    }
}
