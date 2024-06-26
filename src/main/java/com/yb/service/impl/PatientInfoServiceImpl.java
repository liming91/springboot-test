package com.yb.service.impl;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.entity.PatientInfo;
import com.yb.entity.PatientQuestion;
import com.yb.entity.query.PatientInfoQuery;
import com.yb.entity.vo.PatientInfoVo;
import com.yb.exception.ServiceException;
import com.yb.service.PatientInfoService;
import com.yb.mapper.PatientInfoMapper;
import com.yb.service.PatientQuestionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
            Integer count = this.baseMapper.selectCount(new LambdaQueryWrapper<PatientInfo>().eq(PatientInfo::getPatientId, id));
            if (count == 0) {
                rows = this.baseMapper.insert(patientInfo);
                //问题数据入库
                PatientQuestion patientQuestion = new PatientQuestion();
                patientQuestion.setPatientId(id);
                patientQuestion.setQuestion(jsonObject);
                patientQuestion.setCreateTime(new Date());
                patientQuestionService.save(patientQuestion);
            } else {
                rows = this.baseMapper.update(null, new LambdaUpdateWrapper<PatientInfo>()
                        .set(PatientInfo::getHospitalizationNumber, hospitalizationNumber)
                        .set(PatientInfo::getPatientName, patientName)
                        .set(PatientInfo::getSurgicalName, surgicalName)
                        .set(PatientInfo::getSurgicalRoom, surgicalRoom)
                        .set(PatientInfo::getSurgicalTime, DateUtil.parse(surgicalTime))
                        .set(PatientInfo::getDepartment, department)
                        .set(PatientInfo::getCheckTime, checkTime)
                        .set(PatientInfo::getCreateTime, new Date())
                        .eq(PatientInfo::getPatientId, id));
                patientQuestionService.update(new LambdaUpdateWrapper<PatientQuestion>()
                        .set(PatientQuestion::getQuestion, jsonObject.toJSONString())
                        .set(PatientQuestion::getCreateTime, new Date())
                        .eq(PatientQuestion::getPatientId, id));
            }

        } catch (Exception e) {
            log.error("手术信息异常:", e);
            throw new ServiceException("安卓患者信息入库异常");
        }
        return rows;
    }


    @Override
    public List<PatientInfoVo> getPatientInfo(PatientInfoQuery patientInfoQuery) {
        List<PatientInfoVo> patientInfo = this.baseMapper.getPatientInfo(patientInfoQuery);
        List<PatientInfoVo> collect = patientInfo.stream().distinct().collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(collect)) {
            collect.forEach(x -> {
                PatientQuestion patientQuestion = patientQuestionService.getOne(new LambdaQueryWrapper<PatientQuestion>()
                        .eq(PatientQuestion::getPatientId, x.getPatientId()));
                x.setPatientQuestion(patientQuestion);
            });
        }
        return collect;
    }
}




