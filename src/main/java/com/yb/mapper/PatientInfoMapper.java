package com.yb.mapper;

import com.yb.entity.PatientInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yb.entity.query.PatientInfoQuery;
import com.yb.entity.vo.PatientInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* @author Y
* @description 针对表【patient_info】的数据库操作Mapper
* @createDate 2024-06-21 10:56:58
* @Entity com.yb.entity.PatientInfo
*/
@Mapper
public interface PatientInfoMapper extends BaseMapper<PatientInfo> {

    List<PatientInfoVo> getPatientInfo(@Param("patientInfoQuery") PatientInfoQuery patientInfoQuery);
}




