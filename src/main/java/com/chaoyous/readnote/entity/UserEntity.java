package com.chaoyous.readnote.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Data
@TableName(value = "user")
public class UserEntity {
    @TableId(type = IdType.UUID)
    private String id;
    private String nickname;
    private String phone;
    private String password;
    private String imgPath;
}
