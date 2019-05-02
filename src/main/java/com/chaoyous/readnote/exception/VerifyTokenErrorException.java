package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class VerifyTokenErrorException extends CustomException {
    public VerifyTokenErrorException(){
        super(2001,"Verify token error");
    }
}
