package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoyous.readnote.entity.DiscussEntity;
import com.chaoyous.readnote.view.DiscussView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/7
 */
@Mapper
public interface DiscussMapper extends BaseMapper<DiscussEntity>{

    @Update("update discuss set like_num=like_num+#{num} where discuss_id=#{discussId}")
    void mannerDiscussLikeNum(@Param("discussId")String discussId, @Param("num")Integer num);
    @Select("select t1.*,t2.img_path,t2.nickname from discuss t1 LEFT JOIN user t2 on t1.user_id = t2.id where t1.note_id=#{noteId}")
    List<DiscussView> queryDiscussList(@Param("noteId")String noteId);
}
