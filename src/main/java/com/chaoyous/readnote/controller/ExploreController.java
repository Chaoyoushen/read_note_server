package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.annotation.Security;
import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.service.NoteService;
import com.chaoyous.readnote.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    NoteService noteService;

    @RequestMapping(value = "/get")
    ResultEntity getNote(@Security String userId,Integer num,Integer current){
        return ResultBuilder.success("",noteService.getExploreView(num,current,userId));
    }
}
