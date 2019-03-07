package com.bobo.server.servletasync.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-07 10:33
 **/
@Component
public class LoadPropertyUtil implements EnvironmentAware {
    static Environment environment;

    public static final String EMPTY_STRING = "";

    @Override
    public void setEnvironment(Environment environment) {
        LoadPropertyUtil.environment = environment;
    }

    /**
     * 获取配置值, 如果不存在会返回空串
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return environment.getProperty(key, EMPTY_STRING);
    }

    /**
     * 获取配置值, 如果不存在会返回传入的默认值
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(String key, String defaultValue){
        return environment.getProperty(key, defaultValue);
    }

    /**
     * 获取配置值, 如果不存在会返回NULL
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static<T> T getProperty(String key, Class<T> clazz){
        return environment.getProperty(key, clazz, null);
    }

    /**
     * 获取配置值, 如果不存在会返回传入默认值
     * @param key
     * @param clazz
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static<T> T getProperty(String key, Class<T> clazz, T defaultValue){
        return environment.getProperty(key, clazz, defaultValue);
    }

}
