package com.chaoyous.readnote.service;

import com.chaoyous.readnote.view.SearchBookView;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
public interface SearchService {
    SearchBookView searchByISBN(String isbn);
}