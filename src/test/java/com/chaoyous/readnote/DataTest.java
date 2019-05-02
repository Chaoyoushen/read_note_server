package com.chaoyous.readnote;

import com.chaoyous.readnote.entity.UserEntity;
import com.chaoyous.readnote.mapper.BookMapper;
import com.chaoyous.readnote.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DataTest {
    @Autowired
    DataSource dataSource;

   /* @Test
    public void contextDataSource()throws SQLException {

        System.out.print("zcjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        System.out.print(dataSource.getClass());
        Connection conn = dataSource.getConnection();
        System.out.print(conn);
        conn.close();


    }*/


        @Autowired
        private UserMapper userMapper;

//        @Test
//        public void testSelect() {
//            System.out.println(("----- selectAll method test ------"));
//            List<UserEntity> userList = userMapper.selectList(null);
//            // Assert.assertEquals(1, userList.size());
//            // userList.forEach(System.out::println);
//        }
   /* @Autowired
    RedisTemplate<String,String> redisTemplate;
        @Test
    public void testRedis(){
            ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
            //存储一条数据
            valueStr.set("goodsProdu","长安");
            //获取一条数据并输出
            String goodsName = valueStr.get("goodsProdu");
            System.out.println(goodsName);
            //存储多条数据
            Map<String,String> map = new HashMap<>();
            map.put("goodsName","福特汽车");
            map.put("goodsPrice","88888");
            map.put("goodsId","88");

            valueStr.multiSet(map);
            //获取多条数据
            System.out.println("========================================");
            List<String>list = new ArrayList<>();
            list.add("goodsName");
            list.add("goodsPrice");
            list.add("goodsId");
            list.add("goodsProdu");

            List<String> listKeys = valueStr.multiGet(list);
            for (String key : listKeys) {
                System.out.println(key);
            }

        }*/




}
