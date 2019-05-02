package com.chaoyous.readnote.exception;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/11
 */
public class RedisException extends CustomException{
    public RedisException(){
        super(3000,"some things wrong with redis");
    }
}
