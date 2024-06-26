package com.yb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别(1男  2女)
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 用户类型(0内置用户 1注册用户)
     */
    private Integer type;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 地址
     */
    private String address;

    /**
     * 创建人账号
     */
    private Long createById;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人名称
     */
    private String createByName;

    /**
     * 更新人账号
     */
    private Long updateById;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 更新人名称
     */
    private String updateByName;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}