package com.yb.controller;


import com.yb.entity.Test;
import com.yb.service.ITestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HelloController {

    private final ITestService iTestService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        log.info("hello word!");
        return "hello word!";
    }

    @ResponseBody
    @RequestMapping("/test")
    public List<Test> test() {
        return iTestService.selectAll();
    }

}
