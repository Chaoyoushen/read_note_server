package com.chaoyous.readnote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/8
 */
@Data
@TableName(value = "note_like")
@AllArgsConstructor
@NoArgsConstructor
public class LikeNoteEntity {
    private String userId;
    private String noteId;
    private Integer liked;
    @TableId(type = IdType.UUID)
    private String id;

}
