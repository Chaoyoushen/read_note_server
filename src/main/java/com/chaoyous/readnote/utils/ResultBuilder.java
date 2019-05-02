package com.chaoyous.readnote.utils;

import com.chaoyous.readnote.entity.ResultEntity;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class ResultBuilder {

    public static ResultEntity success(String msg, Object data) {
        return new ResultEntity(200, msg, data);
    }

    public static ResultEntity fail(String msg, Object data) {
        return new ResultEntity(400, msg, data);
    }

    public static ResultEntity result(Integer code, String msg, Object data) {
        return new ResultEntity(code, msg, data);
    }
}
