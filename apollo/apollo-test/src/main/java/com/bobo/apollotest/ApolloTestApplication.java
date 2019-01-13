package com.bobo.apollotest;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ApolloTestApplication {

    private static Logger logger = LoggerFactory.getLogger(ApolloTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ApolloTestApplication.class, args);

    }

}

