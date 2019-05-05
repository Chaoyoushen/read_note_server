package com.chaoyous.readnote.service;

import com.chaoyous.readnote.entity.NoteEntity;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
public interface NoteService {
    void saveNote(NoteEntity note);
}
