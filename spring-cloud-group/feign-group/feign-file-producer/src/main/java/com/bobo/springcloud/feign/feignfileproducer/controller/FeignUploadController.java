package com.bobo.springcloud.feign.feignfileproducer.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FeignUploadController {

    private Logger logger = LoggerFactory.getLogger(FeignUploadController.class);

    @PostMapping(value = "/uploadFile/server",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUploadServer(MultipartFile file ) throws Exception{
        String originalFilename = file.getOriginalFilename();
        logger.info("FeignUploadController file name :{}",originalFilename);
        return JSONObject.toJSONString(new ResultInfo());
    }
}
