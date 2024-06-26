package com.yb.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.entity.SysUser;
import com.yb.entity.vo.SysUserVo;
import com.yb.exception.ServiceException;
import com.yb.request.LoginRequest;
import com.yb.service.SysUserService;
import com.yb.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Y
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2024-06-26 10:35:49
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Override
    public SysUserVo login(LoginRequest loginRequest) {
        SysUserVo sysUserVo = new SysUserVo();
        if (StringUtils.isBlank(loginRequest.getUserName()) || StringUtils.isBlank(loginRequest.getPassword())) {
            throw new ServiceException("用户名或密码不能为空！");
        }
        String pwd = SecureUtil.md5(loginRequest.getPassword());
        SysUser sysUser = this.baseMapper.selectOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUserName, loginRequest.getUserName())
                .eq(SysUser::getPassword, pwd));
        if (sysUser == null) {
            throw new ServiceException("用户名或密码错误！");
        }
        BeanUtils.copyProperties(sysUser, sysUserVo);
        return sysUserVo;
    }
}




