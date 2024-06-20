package com.yb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.entity.Test;

import java.util.List;

/**
 * @Author liming
 * @Date 2024/6/20 15:38
 */
public interface ITestService extends IService<Test> {

    List<Test> selectAll();
}
