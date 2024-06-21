package com.yb.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.entity.PatientInfo;
import com.yb.entity.PatientQuestion;
import com.yb.exception.ServiceException;
import com.yb.service.PatientInfoService;
import com.yb.mapper.PatientInfoMapper;
import com.yb.service.PatientQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Y
 * @description 针对表【patient_info】的数据库操作Service实现
 * @createDate 2024-06-21 10:56:58
 */
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PatientInfoServiceImpl extends ServiceImpl<PatientInfoMapper, PatientInfo>
        implements PatientInfoService {

    private final PatientQuestionService patientQuestionService;

    @Override
    public int insertPatientInfo(JSONObject jsonObject) {
        int rows;
        JSONObject ocrModel = jsonObject.getJSONObject("ocrModel");
        Long id = ocrModel.getLong("id");//患者id
        String hospitalizationNumber = ocrModel.getString("hospitalizationNumber");//住院号
        String surgicalName = ocrModel.getString("name");//手术名称
        String patientName = ocrModel.getString("patientName");//患者姓名
        String surgicalRoom = ocrModel.getString("roomName");//手术间
        String surgicalTime = ocrModel.getString("opTime");//手术时间
        String department = ocrModel.getString("department");//科室
        String checkTime = ocrModel.getString("check_time");//核查总用时

        try {
            PatientInfo patientInfo = new PatientInfo();
            patientInfo.setPatientId(id);
            patientInfo.setHospitalizationNumber(hospitalizationNumber);
            patientInfo.setPatientName(patientName);
            patientInfo.setSurgicalName(surgicalName);
            patientInfo.setSurgicalRoom(surgicalRoom);
            patientInfo.setSurgicalTime(DateUtil.parse(surgicalTime));
            patientInfo.setDepartment(department);
            patientInfo.setCheckTime(checkTime);
            patientInfo.setCreateTime(new Date());

            rows = this.baseMapper.insert(patientInfo);

            //TODO 问题数据入库
            JSONObject question = jsonObject.getJSONObject("question");
            JSONObject csq = question.getJSONObject("hzcsq");
            PatientQuestion patientQuestion = new PatientQuestion();
            patientQuestion.setPatientId(id);
            patientQuestion.setAnaesthesiaQuestion(csq.getJSONArray("mzysQuestion"));
            patientQuestion.setOperationQuestion(csq.getJSONArray("ssysQuestion"));
            patientQuestion.setItinerantNurseQuestion(csq.getJSONArray("xhhsQuestion"));
            patientQuestionService.save(patientQuestion);

        } catch (Exception e) {
            log.error("exception message", e);
            throw new ServiceException("安卓患者信息入库异常");
        }

        return rows;
    }


}




