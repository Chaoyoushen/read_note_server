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
 * @date 2019/5/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "note_collection")
public class NoteCollectionEntity {
    private String userId;
    private String noteId;
    @TableId(type = IdType.UUID)
    private String id;
    private Integer flag;
}
