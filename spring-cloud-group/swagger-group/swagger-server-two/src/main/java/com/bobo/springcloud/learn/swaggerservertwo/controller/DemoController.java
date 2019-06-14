package com.bobo.springcloud.learn.swaggerservertwo.controller;

import com.bobo.springcloud.learn.swaggerservertwo.controller.req.DemoReq;
import com.bobo.springcloud.learn.swaggerservertwo.controller.resp.DemoResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo示例
 * @author oKong
 *
 */
@RestController
@Api(tags="servicie-two服务")
@Slf4j
public class DemoController {

	@GetMapping("/hello")
	@ApiOperation(value="demo示例")
	public DemoResp hello(DemoReq demoReq) {
		log.info("DemoReq:{}", demoReq);
		
		return DemoResp.builder()
				.code(demoReq.getCode())
				.name(demoReq.getName())
				.remark(demoReq.getRemark())
				.build();
	}
}
