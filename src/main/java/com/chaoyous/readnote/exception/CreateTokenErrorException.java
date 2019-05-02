package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class CreateTokenErrorException extends CustomException {
    public CreateTokenErrorException(){
        super(2000,"Create token error");
    }
}
