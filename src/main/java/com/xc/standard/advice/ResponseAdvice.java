package com.xc.standard.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xc.standard.response.Response;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**继承ResponseBodyAdvice，对controller返回结果进行拦截
 * 用于提取一些通用逻辑,规范返回结果，保证结果返回为定义的统一Response对象
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    //可以编写逻辑检查，返回结果
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //Controller直接返回String的话，SpringBoot是直接返回,需要手动转换成json。
        if(body instanceof String){
            return objectMapper.writeValueAsString(Response.ok().data(body));
        }
        //如果已经进行了返回结果包装，直接返回结果
        if(body instanceof Response){
            return body;
        }
        // 对结果进行包装
        return Response.ok().data(body);
    }
}
