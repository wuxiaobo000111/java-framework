package com.bobo.springcloud.learn.swaggerserverone.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求实体
 * @author oKong
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class DemoReq {

	@ApiModelProperty(name="code",value="编码",example="104")
	String code;
	
	@ApiModelProperty(name="name",value="名称",example="吴晓波")
	String name;
	
	@ApiModelProperty(name="remark",value="备注",example="吴晓波")
	String remark;
}
