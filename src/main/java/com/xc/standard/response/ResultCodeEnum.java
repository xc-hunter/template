package com.xc.standard.response;

import lombok.Getter;

//结果枚举
@Getter
public enum ResultCodeEnum {
    SUCCESS(true,2000,"成功"),
    UNKNOW_ERROR(false,2001,"通用错误"),
    PARAM_ERROR(false,2002,"参数错误"),
    NULL_POINT(false, 2003, "空指针异常抛出"),
    HTTP_CLIENT_ERROR(false,2004 ,"HttpClient使用出错" );
    //响应是否成功
    private Boolean success;
    //响应状态码
    private Integer code;
    //响应信息
    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
