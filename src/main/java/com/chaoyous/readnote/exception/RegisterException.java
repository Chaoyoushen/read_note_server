package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class RegisterException extends CustomException {
    public RegisterException(){
        super(1002,"Register Failed");
    }
}
