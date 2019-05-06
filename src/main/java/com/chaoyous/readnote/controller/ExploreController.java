package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.entity.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/6
 */
@RestController
@RequestMapping(value = "/explore")
public class ExploreController {
    @RequestMapping(value = "/get")
    ResultEntity getNote(Integer num){
        return null;
    }
}
