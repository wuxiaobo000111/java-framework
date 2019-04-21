package com.bobo.springcloud.feign.feignfileconsumer.service;


import com.bobo.springcloud.feign.feignfileconsumer.config.FeignMultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "feign-file-producer", configuration = FeignMultipartSupportConfig.class)
public interface FileUploadFeignService {

    /***
     * 1.produces,consumes必填
     * 2.注意区分@RequestPart和RequestParam，不要将
     * 不要将@RequestPart(value = "file") 写成@RequestParam(value = "file")
     * @param file
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile/server",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);

}
