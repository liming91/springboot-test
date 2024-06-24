package com.yb.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

/**
 * @TableName patient_question
 */
@TableName(value = "patient_question", autoResultMap = true)
@Data
public class PatientQuestion implements Serializable {


    private static final long serialVersionUID = -743614233930001785L;
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 患者id
     */
    private Long patientId;


    /**
     * 问题
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject question;

    /**
     * 创建时间
     */
    private Date createTime;

}