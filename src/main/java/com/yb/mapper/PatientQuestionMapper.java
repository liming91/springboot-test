package com.yb.mapper;

import com.yb.entity.PatientQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Y
* @description 针对表【patient_question】的数据库操作Mapper
* @createDate 2024-06-21 13:56:03
* @Entity com.yb.entity.PatientQuestion
*/
@Mapper
public interface PatientQuestionMapper extends BaseMapper<PatientQuestion> {

}




