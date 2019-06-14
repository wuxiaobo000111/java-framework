package com.bobo.springcloud.learn.swaggerzuulserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * zuul 内部提供对外服务示例
 * @author oKong
 *
 */
@RestController
@RequestMapping("/demo")
@Api(tags="zuul内部rest api")
public class DemoController {

	@GetMapping("/hello")
	@ApiOperation(value="demo示例",notes="demo示例")
	@ApiImplicitParam(name="name",value="名称",example="oKong")
	public String hello(String name) {
		return "hi," + name + ",this is zuul api! ";
	}
}
