package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoyous.readnote.entity.NoteCollectionEntity;
import com.chaoyous.readnote.view.CollectionListView;
import com.chaoyous.readnote.view.CollectionView;
import com.chaoyous.readnote.view.ExploreListView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/14
 */
@Mapper
public interface NoteCollectionMapper extends BaseMapper<NoteCollectionEntity> {

    @Select("SELECT t1.id,t1.note_id," +
            "t2.book_name,t3.photo_url " +
            "from note_collection t1 " +
            "LEFT JOIN note t2 " +
            "on t1.note_id=t2.note_id " +
            "LEFT JOIN book t3 on t3.book_id=t2.book_id " +
            "where t1.user_id=#{userId} and t2.del_flag=0 and t1.flag=0")
    List<CollectionView> getConllectionList(@Param("userId")String userId);
}
