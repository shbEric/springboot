package com.super404.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
//@RestController = @Controller+@ResponseBody
@RestController
public class SampleController {

    @RequestMapping("/")
    //表示把返回结果映射成json
    @ResponseBody
    String home(){
        return "Hello World!";
    }

    @RequestMapping("/test")
    //@RestController = @Controller+@ResponseBody
    public Map<String,String> testMap(){
        Map<String,String> map = new HashMap<>();
        map.put("name","super404");
        return map;
    }

}
