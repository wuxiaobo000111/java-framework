package com.bobo.springcloud.learn.gatewayinnerfilterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayInnerFilterDemoApplication {

   /* @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("add_request_header_route", r ->
                        r.path("/").filters(f -> f.addRequestHeader("X-Request-Acme", "ValueB"))
                                .uri("http://localhost:8140"))
                .build();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(GatewayInnerFilterDemoApplication.class, args);
    }

}
