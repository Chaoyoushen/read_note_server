package com.chaoyous.readnote.view;

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
public class LoginView implements Serializable {
    private String token;
}
