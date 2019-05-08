package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoyous.readnote.entity.DiscussEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/7
 */
@Mapper
public interface DiscussMapper extends BaseMapper<DiscussEntity>{

    @Update("update discuss set like_num=like_num+#{num} where note_id=#{discussId}")
    void mannerNoteLikeNum(@Param("discussId")String discussId, @Param("num")Integer num);
}
