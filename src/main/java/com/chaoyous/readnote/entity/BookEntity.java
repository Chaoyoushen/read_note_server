package com.chaoyous.readnote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book")
public class BookEntity implements Serializable {
    @TableId(type = IdType.UUID)
    private String bookId;
    private String isbn;
    private String bookName;
    private String author;
    private String publishing;
    private String asin;
    private String brand;
    private String weight;
    private String size;
    private String pages;
    private String price;
    private String photoUrl;
    private String id;
}

