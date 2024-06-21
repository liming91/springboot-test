package com.yb.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName patient_question
 */
@TableName(value ="patient_question")
@Data
public class PatientQuestion implements Serializable {
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
     * 麻醉医生问题
     */
    private JSONArray anaesthesiaQuestion;

    /**
     * 手术医生问题
     */
    private JSONArray operationQuestion;

    /**
     * 巡回护士问题
     */
    private JSONArray itinerantNurseQuestion;

    @TableField(exist = false)
    private static final long serialVersionUID = 2L;
}