package com.chaoyous.readnote.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoyous.readnote.entity.BookEntity;
import com.chaoyous.readnote.entity.SearchBookByISBNFromNetEntity;
import com.chaoyous.readnote.exception.BookNotFoundException;
import com.chaoyous.readnote.exception.MySqlException;
import com.chaoyous.readnote.exception.NoSuchBookException;
import com.chaoyous.readnote.mapper.BookMapper;
import com.chaoyous.readnote.service.SearchService;
import com.chaoyous.readnote.utils.NetUtil;
import com.chaoyous.readnote.view.SearchBookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
@Service
public class SearchServiceImpl implements SearchService {

    final static String ISBN_PREFIX = "http://isbn.szmesoft.com/isbn/query?isbn=";

    @Autowired
    BookMapper bookMapper;

    @Override
    public SearchBookView searchByISBN(String isbn) {
        QueryWrapper<BookEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isbn", isbn);
        BookEntity tmp = bookMapper.selectOne(queryWrapper);
        if (tmp != null) {
            return new SearchBookView(tmp);
        } else {
            String url = ISBN_PREFIX + isbn;
            SearchBookByISBNFromNetEntity book = JSON.parseObject(NetUtil.getJson(url), new TypeReference<SearchBookByISBNFromNetEntity>() {
            });
            if (StringUtils.isEmpty(book.getISBN())) {
                throw new BookNotFoundException();
            }
            tmp = setBookEntity(book);
            bookMapper.insert(tmp);
            return new SearchBookView(tmp);
        }
    }

    @Override
    public SearchBookView searchBookByBookId(String bookId) {
        try {
            QueryWrapper<BookEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("book_id", bookId);
            BookEntity tmp = bookMapper.selectOne(queryWrapper);
            if(tmp != null){
                return new SearchBookView(tmp);
            }else{
                throw new NoSuchBookException();
            }
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    @Override
    public List<SearchBookView> searchBookByBookName(String bookName) {
        try {
            QueryWrapper<BookEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("book_name",bookName);
            List<BookEntity> tmp = bookMapper.selectList(queryWrapper);
            if(tmp == null){
                throw new NoSuchBookException();
            }
            List<SearchBookView> view = new ArrayList<>();
            tmp.forEach((entity) -> view.add(new SearchBookView(entity)));
            return view;
        }catch (Exception e){
            throw new MySqlException();
        }
    }

    BookEntity setBookEntity(SearchBookByISBNFromNetEntity book) {
        BookEntity nbook = new BookEntity();
        nbook.setAsin(book.getASIN());
        nbook.setAuthor(book.getAuthor());
        nbook.setBookName(book.getBookName());
        nbook.setBrand(book.getBrand());
        nbook.setId(book.getID());
        nbook.setPages(book.getPages());
        nbook.setPhotoUrl(book.getPhotoUrl());
        nbook.setPrice(book.getPrice());
        nbook.setPublishing(book.getPublishing());
        nbook.setSize(book.getSize());
        nbook.setWeight(book.getWeight());
        nbook.setIsbn(book.getISBN());
        return nbook;
    }
}
