package com.chaoyous.readnote.handler;

import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.exception.CustomException;
import com.chaoyous.readnote.utils.ResultBuilder;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.net.BindException;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(CustomException.class)
    public ResultEntity customException(CustomException e) {
        return ResultBuilder.fail(e.getMessage(),e.getCode());
    }

    @ExceptionHandler(Exception.class)
    public ResultEntity commonException(){
        return ResultBuilder.result(500,"Error",null);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultEntity httpRequestMethodNotSupportedException(){
        return ResultBuilder.result(403,"Method not allowed",null);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultEntity noHandlerFoundException(){
        return ResultBuilder.result(404,"Not found",null);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, MissingServletRequestParameterException.class, MissingServletRequestPartException.class, BindException.class})
    public ResultEntity paramException(){
        return ResultBuilder.result(403,"Param error",null);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultEntity maxUploadSizeExceededException(){
        return ResultBuilder.result(403,"File too Large",null);
    }
}
