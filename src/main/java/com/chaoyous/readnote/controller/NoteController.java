package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.annotation.Security;
import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.model.DiscussModel;
import com.chaoyous.readnote.service.NoteService;
import com.chaoyous.readnote.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
@RestController
@RequestMapping(value = "/note")
public class NoteController {

    @Autowired
    NoteService noteService;
    @RequestMapping(value = "/save")
    public ResultEntity saveNote(@RequestBody NoteEntity note,@Security String userId){
        noteService.saveNote(note);

        return ResultBuilder.success("ok",'1');
    }
    @RequestMapping(value = "/query/detail")
    public ResultEntity queryNoteDetail(@Security String userId,String noteId){
        return ResultBuilder.success("ok",noteService.getNoteDetail(noteId));
    }

    @RequestMapping(value = "/discuss/add")
    public ResultEntity makeDiscuss(@Security String userId , @RequestBody DiscussModel model){
        if(noteService.makeDiscuss(userId,model)){
            return ResultBuilder.success("ok",null);
        }else{
            return ResultBuilder.fail("error",null);
        }
    }
}
