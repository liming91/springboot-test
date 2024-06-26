package com.yb.service;

import com.yb.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.entity.vo.SysUserVo;
import com.yb.request.LoginRequest;

/**
* @author Y
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2024-06-26 10:35:49
*/
public interface SysUserService extends IService<SysUser> {

    SysUserVo login(LoginRequest loginRequest);
}
