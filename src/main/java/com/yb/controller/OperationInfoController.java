package com.yb.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.yb.exception.ServiceException;
import com.yb.service.PatientInfoService;
import com.yb.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


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
    public CommonResult<JSONObject> education(@RequestBody JSONObject jsonObject) {
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


}
