package com.bobo.springcloud.learn.feigneurekahystrixconsumer.feign;

import feign.Logger;
import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign的配置文件
 */
@Configuration
public class FeignConfig {
    /**
     * 连接超时时间
     */
    @Value("${feign-client-config.ConnectTimeout}")
    private int connectTimeout;

    /**
     *响应时间
     */
    @Value("${feign-client-config.ReadTimeout}")
    private int readTimeout;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }


    /**
     *
     * Logger.Level 的具体级别如下：
     NONE：不记录任何信息
     BASIC：仅记录请求方法、URL以及响应状态码和执行时间
     HEADERS：除了记录 BASIC级别的信息外，还会记录请求和响应的头信息
     FULL：记录所有请求与响应的明细，包括头信息、请求体、元数据
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
