package com.chaoyous.readnote.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
@Data
public class NoteModel implements Serializable {
    String userId;
    String noteId;
    String bookId;
    String digest;
    String note;
    String page;
    String bookName;

}
