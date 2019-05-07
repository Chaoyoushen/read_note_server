package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaoyous.readnote.entity.DiscussEntity;
import com.chaoyous.readnote.entity.NoteEntity;
import com.chaoyous.readnote.view.ExploreView;
import com.chaoyous.readnote.view.NoteDetailView;
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
            "t1.shared_num as sharedNum," +
            "t1.discuss_num as discussNum," +
            "t2.nickname as nickname," +
            "t2.img_path as imgPath " +
            "from note t1 LEFT JOIN user t2 on t1.user_id = t2.id order by createDate limit #{start},#{num}")
    List<ExploreView> selectExploreList(@Param("start") Integer start,@Param("num")Integer num);

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
            "t1.shared_num as sharedNum," +
            "t1.discuss_num as discussNum," +
            "t2.nickname as nickname," +
            "t2.img_path as imgPath " +
            "from note t1 " +
            "LEFT JOIN user t2 on t1.user_id=t2.id " +
            "where t1.note_id=#{noteId} ")
    ExploreView getNoteDetail(@Param("noteId") String noteId);

    @Update("update note set read_num=read_num+1 where note_id=#{noteId}")
    Integer addReadNum(@Param("noteId")String noteId);
}
