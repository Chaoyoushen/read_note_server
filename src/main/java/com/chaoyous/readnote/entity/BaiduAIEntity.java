package com.chaoyous.readnote.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/23
 */
@Component
@ConfigurationProperties(prefix = "baidu-ai")
@Data
public class BaiduAIEntity {
    String apiKey;
    String secretKey;
}
