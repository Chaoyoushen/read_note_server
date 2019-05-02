package com.chaoyous.readnote;

import com.chaoyous.readnote.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JsonTest {
    @Autowired
    SearchService searchService;

//    @Test
//    public void testGetJson(){
//
//        System.out.println(searchService.searchByISBN("9787534155550").getJson());
//    }
//    @Test
//    public void testReturnView(){
//
//        System.err.println(searchService.searchByISBN("97875341545162335556401"));
//    }
}
