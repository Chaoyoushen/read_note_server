package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.annotation.Security;
import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.model.UserValidateModel;
import com.chaoyous.readnote.service.UserService;
import com.chaoyous.readnote.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/login")
    public ResultEntity login(UserValidateModel model) {
        return ResultBuilder.success("login success",userService.login(model));
    }

    @RequestMapping("/register")
    public ResultEntity register(UserValidateModel model) {
        return ResultBuilder.success("register success", userService.register(model));
    }

    @RequestMapping("/check")
    public ResultEntity check(@Security String userId){
        System.out.print(userId);
        return ResultBuilder.success("check success",null);
    }

}
