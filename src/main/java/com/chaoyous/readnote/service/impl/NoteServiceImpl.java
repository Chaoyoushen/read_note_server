package com.chaoyous.readnote.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoyous.readnote.entity.*;
import com.chaoyous.readnote.exception.InsertNoteException;
import com.chaoyous.readnote.exception.MySqlException;
import com.chaoyous.readnote.mapper.*;
import com.chaoyous.readnote.model.DiscussModel;
import com.chaoyous.readnote.service.NoteService;
import com.chaoyous.readnote.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    LikeNoteMapper likeNoteMapper;
    @Autowired
    LikeDiscussMapper likeDiscussMapper;
    @Autowired
    NoteCollectionMapper noteCollectionMapper;


    @Override
    public void saveNote(NoteEntity note) {
        try {
            note.setDiscussNum(0);
            note.setReadNum(0);
            note.setCollectionNum(0);
            note.setLikeNum(0);
            note.setDelFlag(0);
            noteMapper.insert(note);
        }catch (Exception e){
            throw new InsertNoteException();
        }

    }

    @Override
    public ExploreListView getExploreView(Integer num, Integer current,String userId) {
        List<ExploreView> list = noteMapper.selectExploreList(current,num,userId);
        return new ExploreListView(list);
    }

    @Override
    public NoteDetailView getNoteDetail(String noteId,String userId) {
        try {
            noteMapper.addReadNum(noteId);
            ExploreView exploreView = noteMapper.getNoteDetail(noteId,userId);
            NoteDetailView view = getDiscusses(noteId);
            view.setExploreModel(exploreView);
            return view;
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
            noteMapper.addDiscussNum(model.getNoteId(),1);
        }catch (Exception e){
            throw new MySqlException();
        }
        return true;
    }

    @Override
    public NoteDetailView getDiscusses(String noteId) {
        try {
            List<DiscussView> list = discussMapper.queryDiscussList(noteId);
            return new NoteDetailView(null,list);
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public boolean mannerNote(String userId, String noteId) {
        try {
            QueryWrapper<LikeNoteEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId).eq("note_id",noteId);
            LikeNoteEntity model = likeNoteMapper.selectOne(wrapper);
            if(model == null){
                model = new LikeNoteEntity();
                model.setUserId(userId);
                model.setNoteId(noteId);
                model.setLiked(1);
                likeNoteMapper.insert(model);
                noteMapper.mannerNoteLikeNum(noteId,1);
            }else {
                if(model.getLiked() == 1){
                    model.setLiked(0);
                    likeNoteMapper.updateById(model);
                    noteMapper.mannerNoteLikeNum(noteId,-1);
                }else{
                    model.setLiked(1);
                    likeNoteMapper.updateById(model);
                    noteMapper.mannerNoteLikeNum(noteId,1);
                }
            }
            return true;
        }catch (Exception e){
            throw new MySqlException();
        }

    }

    @Override
    public boolean mannerDiscuss(String userId, String discussId) {
        try {
            QueryWrapper<LikeDiscussEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id",userId).eq("discuss_id",discussId);
            LikeDiscussEntity model = likeDiscussMapper.selectOne(wrapper);
            if(model == null){
                model = new LikeDiscussEntity();
                model.setUserId(userId);
                model.setDiscussId(discussId);
                model.setLiked(1);
                likeDiscussMapper.insert(model);
                discussMapper.mannerDiscussLikeNum(discussId,1);
            }else {
                if(model.getLiked() == 1){
                    model.setLiked(0);
                    likeDiscussMapper.updateById(model);
                    discussMapper.mannerDiscussLikeNum(discussId,-1);
                }else{
                    model.setLiked(1);
                    likeDiscussMapper.updateById(model);
                    discussMapper.mannerDiscussLikeNum(discussId,1);
                }
            }
            return true;
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public boolean deleteNote(String noteId) {
        try{
            NoteEntity model = new NoteEntity();
            model.setNoteId(noteId);
            model.setDelFlag(1);
            noteMapper.updateById(model);
            return true;
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public CollectionListView getCollection(String userId) {
        try {
            CollectionListView view = new CollectionListView();
            view.setList(noteCollectionMapper.getConllectionList(userId));
            return view;
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public NoteListView getNote(String userId) {
        try {
            NoteListView view = new NoteListView();
            view.setList(noteMapper.getNote(userId));
            return view;
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public NoteListView getCollectionList(String userId) {
        try{
            NoteListView view = new NoteListView();
            view.setList(noteMapper.getCollectionNote(userId));
            return view;
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public NoteListView getNoteListByBookId(String bookId) {
        try{
            QueryWrapper<NoteEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("book_id",bookId).eq("del_flag",0);
            List<NoteEntity> tmp = noteMapper.selectList(wrapper);
            List<NoteView> list = new ArrayList<>();
            tmp.forEach((entity) -> list.add(new NoteView(entity.getNoteId(),entity.getDigest(),entity.getNote(),entity.getBookName())));
            NoteListView view = new NoteListView();
            view.setList(list);
            return view;
        }catch (Exception e){
            throw new MySqlException();
        }
    }
}
