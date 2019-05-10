package com.chaoyous.readnote.service;

import com.chaoyous.readnote.view.SearchBookView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
public interface SearchService {
    SearchBookView searchByISBN(String isbn);

    SearchBookView searchBookByBookId(String bookId);

    List<SearchBookView> searchBookByBookName(String bookName);
}
