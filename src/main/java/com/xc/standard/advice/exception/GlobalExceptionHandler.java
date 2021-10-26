package com.xc.standard.advice.exception;

import com.xc.standard.tool.ExceptionUtil;
import com.xc.standard.response.Response;
import com.xc.standard.response.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 通用异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response error(Exception e){
        e.printStackTrace();
        return Response.error().data(ExceptionUtil.getMessage(e));
    }

    /**
     * 特定异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Response error(NullPointerException e){
        e.printStackTrace();
        return Response.setResult(ResultCodeEnum.NULL_POINT);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public Response error(HttpClientErrorException e){
        e.printStackTrace();
        return Response.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    @ExceptionHandler(StandardException.class)
    @ResponseBody
    public Response error(StandardException e){
        e.printStackTrace();
        return Response.error().message(e.getMessage()).code(e.getCode());
    }
}
