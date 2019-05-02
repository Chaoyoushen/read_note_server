package com.chaoyous.readnote.controller;

import com.chaoyous.readnote.entity.BaiduAIEntity;
import com.chaoyous.readnote.entity.ResultEntity;
import com.chaoyous.readnote.service.BaiduAIService;
import com.chaoyous.readnote.utils.ResultBuilder;
import com.chaoyous.readnote.view.BaiduAIView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/23
 */
@RestController
@RequestMapping(value = "/baidu")
public class BaiduAIController {

    @Autowired
    private BaiduAIService baiduAIService;

    @RequestMapping("/token")
    public ResultEntity getToken(){
        return ResultBuilder.success("获取成功",baiduAIService.getToken());
    }
}



