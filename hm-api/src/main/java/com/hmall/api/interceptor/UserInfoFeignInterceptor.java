package com.hmall.api.interceptor;

import com.hmall.common.utils.UserContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author unique
 */
public class UserInfoFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        // 获取用户信息
        Long userId = UserContext.getUser();
        // 将用户信息存入请求头
        if (userId != null)
        {
            requestTemplate.header("user-info", String.valueOf(userId));
        }
    }
}
