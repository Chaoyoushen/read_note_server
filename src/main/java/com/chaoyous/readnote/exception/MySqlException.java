package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/7
 */
public class MySqlException extends CustomException {
    public MySqlException() {
        super(1010, "sql error");
    }
}
