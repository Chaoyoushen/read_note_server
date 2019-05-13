package com.chaoyous.readnote.service;

import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.model.DiscussModel;
import com.chaoyous.readnote.view.ExploreListView;
import com.chaoyous.readnote.view.ExploreView;
import com.chaoyous.readnote.view.NoteDetailView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
public interface NoteService {
    void saveNote(NoteEntity note);

    ExploreListView getExploreView(Integer num, Integer current,String userId);

    NoteDetailView getNoteDetail(String noteId);

    boolean makeDiscuss(String userId, DiscussModel model);

    NoteDetailView getDiscusses(String noteId);

    boolean mannerNote(String userId,String noteId);

    boolean mannerDiscuss(String userId,String discussId);

    boolean deleteNote(String noteId);
}
