package com.chaoyous.readnote.entity;

import lombok.Data;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
@Data
public class SearchBookByISBNFromNetEntity {
    private String ISBN;
    private String BookName;
    private String Author;
    private String Publishing;
    private String ASIN;
    private String Brand;
    private String Weight;
    private String Size;
    private String Pages;
    private String Price;
    private String PhotoUrl;
    private String ID;
    private String BookCode;
}
