package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class LoginException extends CustomException{
    public LoginException(){
        super(1001,"login failed");
    }
}
