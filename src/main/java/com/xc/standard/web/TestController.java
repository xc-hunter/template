package com.xc.standard.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/getNormal")
    public String getValue(){
        return "测试";
    }

    @GetMapping("/getError")
    public String getError(){
        int i=9/0;
        return "测试";
    }
}
