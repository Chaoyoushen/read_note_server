package com.chaoyous.readnote.view;

import lombok.Data;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/10
 */
@Data
public class DiscussView {
    private String userId;
    private String discussId;
    private String imgPath;
    private String nickname;
    private String discuss;
    private String createDate;
    private Integer likeNum;
}
