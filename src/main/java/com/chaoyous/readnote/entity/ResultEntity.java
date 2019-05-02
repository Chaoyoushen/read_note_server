package com.chaoyous.readnote.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Data
@AllArgsConstructor
public class ResultEntity implements Serializable{
    private Integer code;
    private String message;
    private Object data;

}
