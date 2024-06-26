package com.yb.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Author liming
 * @Date 2024/6/26 10:40
 */
@Data
@ApiModel(value = "登录请求参数")
public class LoginRequest {

    @NotEmpty(message = "请输入用户名")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotEmpty(message = "请输入密码")
    @ApiModelProperty(value = "密码")
    private String password;
}
