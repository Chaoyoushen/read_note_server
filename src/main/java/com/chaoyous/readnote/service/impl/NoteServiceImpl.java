package com.chaoyous.readnote.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoyous.readnote.entity.DiscussEntity;
import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.exception.InsertNoteException;
import com.chaoyous.readnote.exception.MySqlException;
import com.chaoyous.readnote.mapper.BookMapper;
import com.chaoyous.readnote.mapper.DiscussMapper;
import com.chaoyous.readnote.mapper.NoteMapper;
import com.chaoyous.readnote.mapper.UserMapper;
import com.chaoyous.readnote.model.DiscussModel;
import com.chaoyous.readnote.service.NoteService;
import com.chaoyous.readnote.view.ExploreListView;
import com.chaoyous.readnote.view.ExploreView;
import com.chaoyous.readnote.view.NoteDetailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    @Autowired
    DiscussMapper discussMapper;


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

    @Override
    public NoteDetailView getNoteDetail(String noteId) {
        try {
            noteMapper.addReadNum(noteId);
            ExploreView exploreView = noteMapper.getNoteDetail(noteId);
            QueryWrapper<DiscussEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("note_id",noteId).orderByDesc("create_date");
            List<DiscussEntity> list = discussMapper.selectList(wrapper);

            return new NoteDetailView(exploreView,list);
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public boolean makeDiscuss(String userId, DiscussModel model){
        try {
            DiscussEntity entity = new DiscussEntity();
            entity.setUserId(userId);
            entity.setNoteId(model.getNoteId());
            entity.setDiscuss(model.getDiscuss());
            entity.setCreateDate(model.getCreateDate());
            entity.setLikeNum(0);
            discussMapper.insert(entity);
        }catch (Exception e){
            throw new MySqlException();
        }
        return true;
    }
}
