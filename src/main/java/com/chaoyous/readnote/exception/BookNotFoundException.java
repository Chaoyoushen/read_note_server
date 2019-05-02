package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/27
 */
public class BookNotFoundException extends CustomException {
    public BookNotFoundException() {
        super(1010, "book not found");
    }
}
