package com.bobo.springcloud.feign.feigndemo.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
public class FeignOkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient().newBuilder()
                .connectTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool()).build();
    }
}
