package com.yb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yb.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author liming
 * @Date 2024/6/20 15:42
 */
@Mapper
public interface TesMapper extends BaseMapper<Test> {

    List<Test> selectAll();
}
