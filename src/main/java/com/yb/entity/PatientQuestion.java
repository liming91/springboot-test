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
     * 手术开始前问题
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject beforeSurgeryQuestion;

    /**
     * 麻醉实施前问题
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject narcotismQuestion;


    /**
     * 患者离开手术室前的问题
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject leaveRoomQuestion;

    /**
     * 手术开始前的医生
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject beforeSurgeryDoctor;


    /**
     * 麻醉实施医生
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject narcotismDoctor;


    /**
     * 患者离开手术室前的医生
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject leaveRoomDoctor;

    /**
     * 创建时间
     */
    private Date createTime;

}