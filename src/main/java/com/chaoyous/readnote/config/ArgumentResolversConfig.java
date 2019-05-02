package com.chaoyous.readnote.config;

import com.chaoyous.readnote.handler.ArgumentResolversHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
@Configuration
public class ArgumentResolversConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ArgumentResolversHandler());
    }

}
