package com.chaoyous.readnote.service.impl;

import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.exception.InsertNoteException;
import com.chaoyous.readnote.mapper.NoteMapper;
import com.chaoyous.readnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteMapper noteMapper;
    @Override
    public void saveNote(NoteEntity note) {
        try {
            noteMapper.insert(note);
        }catch (Exception e){
            throw new InsertNoteException();
        }

    }
}
