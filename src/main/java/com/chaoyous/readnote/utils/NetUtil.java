package com.chaoyous.readnote.utils;

import com.chaoyous.readnote.exception.BaiduAIException;
import com.chaoyous.readnote.exception.GetJsonException;
import com.chaoyous.readnote.view.BaiduAIView;
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
 * @date 2019/4/26
 */
public class NetUtil {

    public static String getJson(String url){
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            System.err.println("result:" + result);
            return result;
        } catch (Exception e) {
            throw new GetJsonException();
        }
    }
}
