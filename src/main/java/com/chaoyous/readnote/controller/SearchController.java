package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.service.SearchService;
import com.chaoyous.readnote.utils.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/26
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    SearchService searchService;
    @RequestMapping(value = "/isbn")
    ResultEntity queryBookByISBN(String isbn){
        return ResultBuilder.success("query success",searchService.searchByISBN(isbn));
    }
}
