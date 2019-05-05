package com.chaoyous.readnote.service.impl;

import com.chaoyous.readnote.entity.BaiduAIEntity;
import com.chaoyous.readnote.exception.BaiduAIException;
import com.chaoyous.readnote.exception.GetJsonException;
import com.chaoyous.readnote.service.BaiduAIService;
import com.chaoyous.readnote.utils.NetUtil;
import com.chaoyous.readnote.view.BaiduAIView;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class BaiduAIServiceImpl implements BaiduAIService {

    private static final String AUTH_HOST = "https://aip.baidubce.com/oauth/2.0/token?";
    @Autowired
    BaiduAIEntity baiduAIEntity;

    @Override
    public BaiduAIView getToken(){
        String getAccessTokenUrl = AUTH_HOST
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + baiduAIEntity.getApiKey()
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + baiduAIEntity.getSecretKey();
        String result = NetUtil.getJson(getAccessTokenUrl);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(result);
            return new BaiduAIView(jsonObject.getString("access_token"));
        } catch (JSONException e) {
            throw new GetJsonException();
        }
    }
}
