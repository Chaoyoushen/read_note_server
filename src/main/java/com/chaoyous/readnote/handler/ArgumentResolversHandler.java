package com.chaoyous.readnote.handler;

import com.chaoyous.readnote.annotation.Security;
import com.chaoyous.readnote.exception.VerifyTokenErrorException;
import com.chaoyous.readnote.utils.CommonUtils;
import com.chaoyous.readnote.utils.RedisUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/4/10
 */
public class ArgumentResolversHandler implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(Security.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("token");
        try {
            String userId = CommonUtils.tokenVerify(token);
            return userId;
        }catch (Exception e){
            throw new VerifyTokenErrorException();
        }
    }
}
