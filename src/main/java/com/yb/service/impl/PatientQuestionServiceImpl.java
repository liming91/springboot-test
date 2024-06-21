package com.yb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.entity.PatientQuestion;
import com.yb.service.PatientQuestionService;
import com.yb.mapper.PatientQuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author Y
* @description 针对表【patient_question】的数据库操作Service实现
* @createDate 2024-06-21 13:56:03
*/
@Service
public class PatientQuestionServiceImpl extends ServiceImpl<PatientQuestionMapper, PatientQuestion>
    implements PatientQuestionService{

}




