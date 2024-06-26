package com.yb.controller;

import com.yb.request.LoginRequest;
import com.yb.service.SysUserService;
import com.yb.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author liming
 * @Date 2024/6/26 10:36
 */
@Slf4j
@Api(tags = "登陆")
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final SysUserService sysUserService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public CommonResult<?> login(@Validated @RequestBody LoginRequest loginRequest) {
        return CommonResult.data(sysUserService.login(loginRequest));
    }

}
