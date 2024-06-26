package com.yb.service;

import com.alibaba.fastjson.JSONObject;
import com.yb.entity.PatientInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.entity.query.PatientInfoQuery;
import com.yb.entity.vo.PatientInfoVo;

import java.util.List;

/**
* @author Y
* @description 针对表【patient_info】的数据库操作Service
* @createDate 2024-06-21 10:56:58
*/
public interface PatientInfoService extends IService<PatientInfo> {

    int insertPatientInfo(JSONObject jsonObject);

    List<PatientInfoVo> getPatientInfo(PatientInfoQuery patientInfoQuery);
}
