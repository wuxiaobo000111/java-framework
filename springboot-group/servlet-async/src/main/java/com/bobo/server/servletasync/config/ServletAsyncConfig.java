package com.bobo.server.servletasync.config;

import com.bobo.server.servletasync.threadpool.ThreadPoolFactory;
import com.bobo.server.servletasync.threadpool.ThreadPoolManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置信息
 * @create 2019-03-06 21:18
 **/
@Configuration
@Slf4j
public class ServletAsyncConfig {

    @Bean
    public ThreadPoolFactory threadPoolFactory () {
        log.info("threadPoolFactory init");
        return new ThreadPoolFactory();
    }

    @Bean
    public ThreadPoolManage threadPoolManage() {
        log.info("threadPoolManage init");
        return new ThreadPoolManage();
    }
}
