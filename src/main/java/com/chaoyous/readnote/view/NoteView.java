package com.chaoyous.readnote.view;

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
public class NoteView {
    private String noteId;
    private String digest;
    private String note;
    private String bookName;
}
