package com.chaoyous.readnote.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoyous.readnote.entity.NoteCollectionEntity;
import com.chaoyous.readnote.entity.UserEntity;
import com.chaoyous.readnote.exception.LoginException;
import com.chaoyous.readnote.exception.MySqlException;
import com.chaoyous.readnote.exception.RedisException;
import com.chaoyous.readnote.exception.RegisterException;
import com.chaoyous.readnote.mapper.NoteCollectionMapper;
import com.chaoyous.readnote.mapper.NoteMapper;
import com.chaoyous.readnote.mapper.UserMapper;
import com.chaoyous.readnote.model.UserValidateModel;
import com.chaoyous.readnote.service.UserService;
import com.chaoyous.readnote.utils.CommonUtils;
import com.chaoyous.readnote.utils.RedisUtil;
import com.chaoyous.readnote.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


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
    @Autowired
    NoteCollectionMapper notecollectionMapper;
    @Autowired
    NoteMapper noteMapper;

    @Override
    public LoginView login(UserValidateModel model){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",model.getPhone()).eq("password",CommonUtils.getMD5(model.getPassword()));
        UserEntity user = userMapper.selectOne(queryWrapper);
        if(null != user){
            String token = CommonUtils.tokenMaker(user.getId());
            RedisUtil.set(user.getId(),token,864000);
            return new LoginView(token,user.getId(),user.getNickname());
        }
        throw new LoginException();
    }

    @Override
    public LoginView register(UserValidateModel model){
        String token;
        UserEntity user = new UserEntity();
        user.setPassword(CommonUtils.getMD5(model.getPassword()));
        user.setPhone(model.getPhone());
        user.setNickname("书友" + CommonUtils.getRandomString(5));
        user.setImgPath("default_img");
        user.setId(CommonUtils.getUUID());
        try {
            userMapper.insert(user);
            token = CommonUtils.tokenMaker(user.getId());
        }catch (Exception e){
            throw  new RegisterException();
        }
       RedisUtil.set(user.getId(),token,864000);
        return new LoginView(token,user.getId(),user.getNickname());

    }

    @Override
    public void logout(String userId) {
        try{
            RedisUtil.del(userId);
        }catch (Exception e){
            throw new RedisException();
        }
    }

    @Override
    public void changeName(String userId, String newName) {
        try{
            UserEntity user = new UserEntity();
            user.setId(userId);
            user.setNickname(newName);
            userMapper.updateById(user);
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public void doCollection(String userId, String noteId) {
        try{
            QueryWrapper<NoteCollectionEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id",userId).eq("note_id",noteId);
            NoteCollectionEntity nce = notecollectionMapper.selectOne(queryWrapper);
            if (nce == null) {
                NoteCollectionEntity model = new NoteCollectionEntity();
                model.setFlag(0);
                model.setNoteId(noteId);
                model.setUserId(userId);
                notecollectionMapper.insert(model);
                noteMapper.addCollectionNum(noteId,1);
            }else if(nce.getFlag()==0){
                nce.setFlag(1);
                notecollectionMapper.updateById(nce);
                noteMapper.addCollectionNum(noteId,-1);
            }else{
                nce.setFlag(0);
                notecollectionMapper.updateById(nce);
                noteMapper.addCollectionNum(noteId,1);
            }
        }catch (Exception e){
            throw new MySqlException();
        }
    }


}
