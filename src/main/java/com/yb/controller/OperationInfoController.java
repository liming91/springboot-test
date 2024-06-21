package com.yb.controller;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.yb.entity.PatientInfo;
import com.yb.entity.query.PatientInfoQuery;
import com.yb.entity.vo.PatientInfoVo;
import com.yb.exception.ServiceException;
import com.yb.service.PatientInfoService;
import com.yb.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 接受安卓推送的手术信息
 *
 * @Author liming
 * @Date 2024/6/20 15:56
 */
@Slf4j
@Api(tags = "接受安卓推送的手术信息")
@RestController
@RequiredArgsConstructor
@RequestMapping("/operation")
public class OperationInfoController {

    private final PatientInfoService patientInfoService;


    @ApiOperation("手术信息入库")
    @PostMapping("/info")
    public CommonResult<JSONObject> insertPatientInfo(@RequestBody JSONObject jsonObject) {
        log.info("手术信息jsonObject==:{}", jsonObject);
        if (ObjectUtil.isEmpty(jsonObject)) {
            throw new ServiceException("参数异常!");
        }
        int rows = patientInfoService.insertPatientInfo(jsonObject);
        if (rows != 0) {
            return CommonResult.ok();
        } else {
            return CommonResult.error();
        }
    }

    @ApiOperation("列表")
    @GetMapping("/getPatientInfo")
    public CommonResult<List<PatientInfoVo>> getPatientInfo(PatientInfoQuery patientInfoQuery) {
        List<PatientInfoVo> list = patientInfoService.getPatientInfo(patientInfoQuery);
        return CommonResult.data(list);
    }


}
