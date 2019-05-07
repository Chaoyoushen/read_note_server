package com.chaoyous.readnote.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.exception.InsertNoteException;
import com.chaoyous.readnote.mapper.BookMapper;
import com.chaoyous.readnote.mapper.NoteMapper;
import com.chaoyous.readnote.mapper.UserMapper;
import com.chaoyous.readnote.service.NoteService;
import com.chaoyous.readnote.view.ExploreListView;
import com.chaoyous.readnote.view.ExploreView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;


    @Override
    public void saveNote(NoteEntity note) {
        try {
            note.setDiscussNum(0);
            note.setReadNum(0);
            note.setShareNum(0);
            note.setStarNum(0);
            noteMapper.insert(note);
        }catch (Exception e){
            throw new InsertNoteException();
        }

    }

    @Override
    public ExploreListView getExploreView(Integer num, Integer current) {
        List<ExploreView> list = noteMapper.selectExploreList(current-1,num);
        return new ExploreListView(list);
    }
}
