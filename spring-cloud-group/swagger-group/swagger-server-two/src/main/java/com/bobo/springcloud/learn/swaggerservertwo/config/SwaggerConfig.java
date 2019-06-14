package com.bobo.springcloud.learn.swaggerservertwo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				// 是否开启
				.enable(true).select()
				// 扫描的路径包
				.apis(RequestHandlerSelectors.basePackage("com.bobo.springcloud.learn.swaggerservertwo"))
				// 指定路径处理PathSelectors.any()代表所有的路径
				.paths(PathSelectors.any()).build().pathMapping("/");
	}

	//设置api信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("路由网关(Zuul)：利用swagger2聚合API文档-service-two")
				.description("吴晓波")
				// 作者信息
				.contact(new Contact("wuxiaobo", "https://github.com/wuxiaobo000111/Java--apollo",
						"17600148757@163.com"))
				.version("1.0.0")
				.build();
	}
}
