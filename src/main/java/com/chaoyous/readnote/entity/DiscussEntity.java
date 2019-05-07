package com.chaoyous.readnote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "discuss")
public class DiscussEntity implements Serializable {
    @TableId(type = IdType.UUID)
    private String discussId;
    private String userId;
    private String discuss;
    private String createDate;
    private Integer likeNum;
    private String noteId;
}
