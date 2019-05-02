package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoyous.readnote.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
@Mapper
public interface BookMapper extends BaseMapper<BookEntity> {
}
