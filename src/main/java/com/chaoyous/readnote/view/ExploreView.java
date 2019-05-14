package com.chaoyous.readnote.view;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/6
 */
@Data
@AllArgsConstructor
public class ExploreView {
    private String digest;
    private String bookId;
    private String bookName;
    private String userId;
    private String noteId;
    private String imgPath;
    private String nickname;
    private String createDate;
    private Integer readNum;
    private Integer likeNum;
    private Integer discussNum;
    private Integer collectionNum;
    private String note;
    private String page;
    private Integer likeFlag;
    private Integer collectionFlag;
}
