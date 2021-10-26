package com.xc.standard.advice.exception;

import com.xc.standard.response.ResultCodeEnum;
import lombok.Data;

@Data
public class StandardException extends RuntimeException{

    private Integer code;

    public StandardException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public StandardException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "StandardException{" +
                "code=" + code +",message="+this.getMessage()+
                '}';
    }
}
