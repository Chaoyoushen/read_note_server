package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.annotation.Security;
import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.model.UserValidateModel;
import com.chaoyous.readnote.service.NoteService;
import com.chaoyous.readnote.service.UserService;
import com.chaoyous.readnote.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    NoteService noteService;

    @RequestMapping("/login")
    public ResultEntity login(@RequestBody UserValidateModel model) {
        return ResultBuilder.success("login success",userService.login(model));
    }

    @RequestMapping("/register")
    public ResultEntity register(@RequestBody UserValidateModel model) {
        return ResultBuilder.success("register success", userService.register(model));
    }

    @RequestMapping("/logout")
    public ResultEntity logout(@Security String userId){
        userService.logout(userId);
        return ResultBuilder.success("ok",null);
    }

    @RequestMapping("/check")
    public ResultEntity check(@Security String userId){
        return ResultBuilder.success("ok",null);
    }

    @RequestMapping("/changeName")
    public ResultEntity changeName(@Security String userId,String newName){
        userService.changeName(userId,newName);
        return ResultBuilder.success("ok",null);
    }

    @RequestMapping("/collectionOverview")
    public ResultEntity getCollectionOverview(@Security String userId){
        return ResultBuilder.success("ok",noteService.getCollection(userId));
    }

    @RequestMapping("/noteOverview")
    public ResultEntity getNoteOverview(@Security String userId){
        return ResultBuilder.success("ok",noteService.getNote(userId));
    }

    @RequestMapping("/collection")
    public ResultEntity doCollection(@Security String userId,String noteId){
        userService.doCollection(userId,noteId);
        return ResultBuilder.success("ok",null);
    }

    @RequestMapping("/collection/list")
    public ResultEntity getCollectionList(@Security String userId){
        return ResultBuilder.success("ok",noteService.getCollectionList(userId));
    }




}
