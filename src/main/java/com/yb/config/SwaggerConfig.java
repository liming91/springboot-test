package com.yb.config;

import com.yb.util.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author liming
 * @Date 2024/6/20 16:34
 */
@Configuration
public class SwaggerConfig {
    /**
     * API文档分组配置
     **/
    @Bean(value = "baseDocApi")
    public Docket baseDocApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("基础模块")
                        .description("基础模块")
                        .termsOfServiceUrl("https://www.yb.com")
                        .contact(new Contact("YB_HUB_TEAM", "www.yb.com", "wilton.icp@gmail.com"))
                        .version("1.0.0")
                        .build())
                .globalResponseMessage(RequestMethod.GET, CommonResult.responseList())
                .globalResponseMessage(RequestMethod.POST, CommonResult.responseList())
                .groupName("基础模块")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.yb"))
                .paths(PathSelectors.any())
                .build();
    }
}
