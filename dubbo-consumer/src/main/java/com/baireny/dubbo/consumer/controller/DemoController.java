package com.baireny.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baireny.dubbo.api.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @Reference
   private DemoService demoService;

    @GetMapping("/sayHello/{name}")
    public  String sayHell(@PathVariable("name") String name){

        return demoService.sayHello(name);
    }


}

