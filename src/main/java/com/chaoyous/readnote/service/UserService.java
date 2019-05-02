package com.chaoyous.readnote.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoyous.readnote.entity.UserEntity;
import com.chaoyous.readnote.model.UserValidateModel;
import com.chaoyous.readnote.view.LoginView;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public interface UserService extends IService<UserEntity> {
    LoginView login(UserValidateModel model);

    LoginView register(UserValidateModel model);
}
