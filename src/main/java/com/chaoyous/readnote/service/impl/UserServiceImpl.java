package com.chaoyous.readnote.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoyous.readnote.entity.UserEntity;
import com.chaoyous.readnote.exception.LoginException;
import com.chaoyous.readnote.exception.RegisterException;
import com.chaoyous.readnote.mapper.UserMapper;
import com.chaoyous.readnote.model.UserValidateModel;
import com.chaoyous.readnote.service.UserService;
import com.chaoyous.readnote.utils.CommonUtils;
import com.chaoyous.readnote.utils.RedisUtil;
import com.chaoyous.readnote.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public LoginView login(UserValidateModel model){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",model.getPhone()).eq("password",CommonUtils.getMD5(model.getPassword()));
        UserEntity user = userMapper.selectOne(queryWrapper);
        if(null != user){
            String token = CommonUtils.tokenMaker(user.getId());
            RedisUtil.set(user.getId(),token,864000);
            return new LoginView(token);
        }
        throw new LoginException();
    }

    @Override
    public LoginView register(UserValidateModel model){
        String token;
        UserEntity user = new UserEntity();
        user.setPassword(CommonUtils.getMD5(model.getPassword()));
        user.setPhone(model.getPhone());
        user.setId(CommonUtils.getUUID());
        try {
            userMapper.insert(user);
            token = CommonUtils.tokenMaker(user.getId());
        }catch (Exception e){
            throw  new RegisterException();
        }
       RedisUtil.set(user.getId(),token,864000);
        return new LoginView(token);

    }

}