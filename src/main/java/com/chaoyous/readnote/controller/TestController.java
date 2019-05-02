package com.chaoyous.readnote.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/3/1
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }

}
