package com.chaoyous.readnote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoyous.readnote.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
