package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoyous.readnote.entity.DiscussEntity;
import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.view.ExploreView;
import com.chaoyous.readnote.view.NoteDetailView;
import com.chaoyous.readnote.view.NoteListView;
import com.chaoyous.readnote.view.NoteView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
@Mapper
public interface NoteMapper extends BaseMapper<NoteEntity> {


    /***
     *
     * @param  page 分页对象传递参数 Page 即自动分页,必须放在第一位
     * @param state 状态
     * @return 分页对象
     */
    IPage<NoteEntity> selectPageVo(Page page, @Param("state") Integer state);

    @Select("select t1.user_id as userId," +
            "t1.note_id as noteId," +
            "t1.book_id as bookId," +
            "t1.digest as digest," +
            "t1.create_date as createDate," +
            "t1.note as note," +
            "t1.page as page," +
            "t1.book_name as bookName," +
            "t1.read_num as readNum," +
            "t1.like_num as likeNum," +
            "t1.collection_num as collectionNum," +
            "t1.discuss_num as discussNum," +
            "t2.nickname as nickname," +
            "t2.img_path as imgPath," +
            "t3.liked as flag,"+
            "t4.flag as collectionFlag "+
            "from note t1 LEFT JOIN user t2 on t1.user_id = t2.id "+
            "LEFT JOIN (select * from note_like where user_id =#{userId})as t3 ON t1.note_id = t3.note_id "+
            "LEFT JOIN (select * from note_collection where user_id =#{userId})as t4 ON t1.note_id = t4.note_id "+
            "where t1.del_flag=0 order by createDate limit #{start},#{num}")
    List<ExploreView> selectExploreList(@Param("start") Integer start,@Param("num")Integer num,@Param("userId")String userId);

    @Select("select t1.user_id as userId,t1.note_id as noteId,t1.book_id as bookId,t1.digest as digest, " +
            "t1.create_date as createDate,t1.note as note,t1.page as page,t1.book_name as bookName, " +
            "t1.read_num as readNum,t1.like_num as likeNum,t1.collection_num as collectionNum,t1.discuss_num as discussNum,t2.nickname as nickname, " +
            "t2.img_path as imgPath,t4.liked as likeFlag ,t3.flag as collectionFlag " +
            "from note t1 LEFT JOIN user t2 on t1.user_id=t2.id " +
            "LEFT JOIN note_collection t3 on t1.note_id=t3.note_id " +
            "LEFT JOIN note_like t4 on t1.note_id=t4.note_id " +
            "where t1.del_flag=0 and t1.note_id=#{noteId}")
    ExploreView getNoteDetail(@Param("noteId") String noteId);

    @Update("update note set read_num=read_num+1 where note_id=#{noteId}")
    Integer addReadNum(@Param("noteId")String noteId);

    @Update("update note set discuss_num=discuss_num+#{num} where note_id=#{noteId}")
    Integer addDiscussNum(@Param("noteId")String noteId,@Param("num")Integer num);

    @Update("update note set like_num=like_num+#{num} where note_id=#{noteId}")
    Integer addLikeNum(@Param("noteId")String noteId,@Param("num")Integer num);

    @Update("update note set collection_num=collection_num+#{num} where note_id=#{noteId}")
    Integer addCollectionNum(@Param("noteId")String noteId,@Param("num")Integer num);

    @Select("select count(*) from note_like where note_id=#{noteId} and user_id=#{userId}")
    Integer checkLikeFlag(@Param("userId")String userId,@Param("noteId")String noteId);
    @Update("update note set like_num=like_num+#{num} where note_id=#{noteId}")
    void mannerNoteLikeNum(@Param("noteId")String noteId,@Param("num")Integer num);

    @Select("SELECT t1.book_name,t1.note,t1.digest,t1.note_id from note t1 where user_id=#{userId} and del_flag=0")
    List<NoteView> getNote(@Param("userId")String userId);

    @Select("select t1.note_id,t2.note,t2.digest,t2.book_name from note_collection t1 " +
            "LEFT JOIN note t2 on t1.note_id=t2.note_id " +
            "LEFT JOIN user t3 on t1.user_id=t3.id " +
            "where t1.flag=0 and t2.del_flag=0 and t1.user_id=#{userId} and t2.del_flag=0")
    List<NoteView> getCollectionNote(@Param("userId")String userId);
}
