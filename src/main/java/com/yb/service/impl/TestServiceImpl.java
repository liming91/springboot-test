package com.yb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.entity.Test;
import com.yb.mapper.TesMapper;
import com.yb.service.ITestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author liming
 * @Date 2024/6/20 15:41
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl extends ServiceImpl<TesMapper, Test> implements ITestService {

    private final TesMapper tesMapper;


    @Override
    public List<Test> selectAll() {
        return tesMapper.selectAll();
    }
}
