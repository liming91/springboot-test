package com.yb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 患者信息
 *
 * @TableName patient_info
 */
@TableName(value = "patient_info")
@Data
public class PatientInfo implements Serializable {

    private static final long serialVersionUID = 3734860732252956804L;

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
     * 或者住院号
     */
    private String hospitalizationNumber;

    /**
     * 患者姓名
     */
    private String patientName;


    /**
     * 手术名称
     */
    private String surgicalName;

    /**
     * 手术间
     */
    private String surgicalRoom;

    /**
     * 手术时间
     */
    private Date surgicalTime;

    /**
     * 科室
     */
    private String department;

    /**
     * 核查总用时
     */
    private String checkTime;

    /**
     * 创建时间
     */
    private Date createTime;


}