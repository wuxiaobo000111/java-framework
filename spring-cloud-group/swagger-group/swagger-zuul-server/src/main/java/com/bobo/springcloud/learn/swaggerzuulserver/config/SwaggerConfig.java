package com.bobo.springcloud.learn.swaggerzuulserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
@Primary //多个bean时 此类优先使用
public class SwaggerConfig implements SwaggerResourcesProvider {

    @Autowired
    RouteLocator routeLocator;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(true).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.bobo.springcloud.learn.swaggerzuulserver"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    //设置api信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("路由网关(Zuul)：利用swagger2聚合API文档")
                .description("吴晓波")
                // 作者信息
                .contact(new Contact("吴晓波", "https://github.com/wuxiaobo000111/Java--apollo", "17600148757@163.com"))
                .version("1.0.0")
                .termsOfServiceUrl("https://github.com/wuxiaobo000111/Java--apollo")
                .build();
    }

    @Override
    public List<SwaggerResource> get() {
        //利用routeLocator动态引入微服务
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("swagger-zuul-server", "/v2/api-docs", "1.0"));
        //循环 使用Lambda表达式简化代码
        routeLocator.getRoutes().forEach(route -> {
            //动态获取
            resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "1.0"));
        });
        //也可以直接 继承 Consumer接口
//		routeLocator.getRoutes().forEach(new Consumer<Route>() {
//
//			@Override
//			public void accept(Route t) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
