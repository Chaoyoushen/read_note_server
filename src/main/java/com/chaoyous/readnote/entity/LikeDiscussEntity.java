package com.chaoyous.readnote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "discuss_like")
public class LikeDiscussEntity {
    private String discussId;
    private String userId;
    @TableId(type = IdType.UUID)
    private String id;
    private Integer liked;
}
