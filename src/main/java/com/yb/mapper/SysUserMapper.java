package com.yb.mapper;

import com.yb.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Y
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2024-06-26 10:35:49
* @Entity com.yb.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}




