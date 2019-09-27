package com.baireny.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baireny.dubbo.api.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Service
@Api(description = "测试服务")
@RestController
public class DemoServiceImpl implements DemoService {

    @Override
    @ApiOperation(value = "sayHello" ,notes ="对访问者打招呼")
    @GetMapping(value = "/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello "+name;
    }
}
