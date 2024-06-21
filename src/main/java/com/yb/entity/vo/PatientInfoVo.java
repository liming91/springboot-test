package com.yb.entity.vo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yb.entity.PatientQuestion;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author liming
 * @Date 2024/6/21 15:58
 */
@Data
@TableName( autoResultMap = true)
@ApiModel(value = "患者信息")
public class PatientInfoVo {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "患者id")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date surgicalTime;

    /**
     * 科室
     */
    private String department;

    /**
     * 核查总用时
     */
    private String checkTime;


    private PatientQuestion patientQuestion;


}
