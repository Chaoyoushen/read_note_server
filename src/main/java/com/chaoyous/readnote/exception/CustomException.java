package com.chaoyous.readnote.exception;

import com.chaoyous.readnote.entity.ResultEntity;
import lombok.Data;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Data
public class CustomException extends RuntimeException{
    private Integer code;
    public CustomException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
