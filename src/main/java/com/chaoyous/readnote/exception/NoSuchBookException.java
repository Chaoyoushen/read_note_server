package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/10
 */
public class NoSuchBookException extends CustomException {
    public NoSuchBookException() {
        super(1021, "no such book");
    }
}
