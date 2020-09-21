package com.ecnu.edu.petapibase.entity.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 基础响应
 *
 * @author 13862
 */
@Data
public class CommonRes {
    public static final Integer SUCCESS_STATUS = 1;
    public static final Integer FAIL_STATUS = 0;
    @ApiModelProperty("响应实体")
    private Object resBody;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应时间")
    private Integer costTime;

    public CommonRes() {

    }

    public CommonRes(Object resBody, Integer status, String message) {
        this.resBody = resBody;
        this.status = status;
        this.message = message;
    }

    public static CommonRes getCommonRes(Integer status, String message, Object resBody) {
        return new CommonRes(resBody, status, message);
    }

    public static CommonRes getCommonRes(Integer status, Object resBody) {
        return new CommonRes(resBody, status, StringUtils.EMPTY);
    }

    public static CommonRes getCommonRes(Integer status, String message) {
        return new CommonRes(null, status, message);
    }
}
