package com.yb.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        log.info("hello word!");
        return "hello word!";
    }

}
