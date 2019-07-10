package com.bobo.springboot.learn.springbootstarterdemo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("my.hello")
public class HelloProperties {

        /**
         * 姓名
         */
        private String name;

        /**
         * 年龄
         */
        private Integer age;

        /**
         * 家乡
         */
        private String hometown;

}