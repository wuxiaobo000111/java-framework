package com.bobo.springcloud.learn.hystrixeurekaexception.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FallbackBadRequestExpcetionService extends HystrixCommand<String>{


	private static Logger log = LoggerFactory.getLogger(FallbackBadRequestExpcetionService.class);

    public FallbackBadRequestExpcetionService() {
        super(HystrixCommandGroupKey.Factory.asKey("GroupBRE"));
    }


	@Override
	protected String run() {
		 throw new HystrixBadRequestException("HystrixBadRequestException error");
	}
	
    @Override
    protected String getFallback() {
    	System.out.println(getFailedExecutionException().getMessage());
        return "invoke HystrixBadRequestException fallback method:  ";
    }
	
	
}
