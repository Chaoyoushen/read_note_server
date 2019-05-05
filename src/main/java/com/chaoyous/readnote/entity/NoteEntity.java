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
 * @date 2019/5/4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "note")
public class NoteEntity implements Serializable {
    String userId;
    @TableId(type = IdType.UUID)
    String noteId;
    String bookId;
    String digest;
    String note;
    String page;
    String bookName;

}
