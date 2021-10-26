package com.xc.standard.response;

import lombok.Data;

@Data
public class Response<T> {

    private Boolean success;

    private Integer code;

    private  String message;

    private long timestamp;

    //返回数据，响应数据定义为JSON格式，可使用Map或者JsonObject
    private T data;

    //构造器私有化
    private Response() {
        this.timestamp = System.currentTimeMillis();
    }

    //定义一些通用响应
    //返回成功
    public static Response ok(){
        Response response=new Response();
        response.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        response.setCode(ResultCodeEnum.SUCCESS.getCode());
        response.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return response;
    }

    //返回失败，未知错误
    public static Response error(){
        Response response=new Response();
        response.setSuccess(ResultCodeEnum.UNKNOW_ERROR.getSuccess());
        response.setCode(ResultCodeEnum.UNKNOW_ERROR.getCode());
        response.setMessage(ResultCodeEnum.UNKNOW_ERROR.getMessage());
        return response;
    }

    //设置结构，形参为结果枚举
    public static Response setResult(ResultCodeEnum result){
        Response response=new Response();
        response.setSuccess(result.getSuccess());
        response.setCode(result.getCode());
        response.setMessage(result.getMessage());
        return response;
    }

    //使用链式编程，返回this

    //自定义返回数据
    public Response data(T data){
        this.setData(data);
        return this;
    }



    //自定义状态信息
    public Response message(String message){
        this.setMessage(message);
        return this;
    }

    //自定义状态码
    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    //自定义返回标识
    public Response success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    //
}
