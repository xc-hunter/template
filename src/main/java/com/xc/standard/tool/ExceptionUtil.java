package com.xc.standard.tool;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class ExceptionUtil {

    /**
     * 提取异常的说明信息
     * @param e 异常
     * @return
     */
    public static String getMessage(Exception e){
        String swStr=null;
        try(StringWriter sw=new StringWriter(); PrintWriter pw=new PrintWriter(sw)){
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            swStr=sw.toString();
        }catch (IOException ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
        return swStr;
    }
}
