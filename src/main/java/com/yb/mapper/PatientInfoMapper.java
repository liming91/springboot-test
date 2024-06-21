package com.yb.mapper;

import com.yb.entity.PatientInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Y
* @description 针对表【patient_info】的数据库操作Mapper
* @createDate 2024-06-21 10:56:58
* @Entity com.yb.entity.PatientInfo
*/
@Mapper
public interface PatientInfoMapper extends BaseMapper<PatientInfo> {

}




