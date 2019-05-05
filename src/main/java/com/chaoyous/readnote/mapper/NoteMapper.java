package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoyous.readnote.entity.NoteEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/4
 */
@Mapper
public interface NoteMapper extends BaseMapper<NoteEntity> {
}
