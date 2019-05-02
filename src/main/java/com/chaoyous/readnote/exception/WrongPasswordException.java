package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class WrongPasswordException extends CustomException {
    public WrongPasswordException() {
        super(1000, "wrong password");
    }
}
