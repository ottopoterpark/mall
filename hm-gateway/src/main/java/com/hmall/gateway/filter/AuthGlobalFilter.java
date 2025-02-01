package com.hmall.gateway.filter;

import cn.hutool.jwt.JWTUtil;
import com.hmall.common.exception.UnauthorizedException;
import com.hmall.common.utils.CollUtils;
import com.hmall.gateway.config.AuthProperties;
import com.hmall.gateway.utils.JwtTool;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author unique
 */
@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(AuthProperties.class)
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private final JwtTool jwtTool;
    private final AuthProperties authProperties;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        // 获取Request
        ServerHttpRequest request = exchange.getRequest();
        // 判断是否需要拦截
        if (isExclude(request.getPath().toString()))
        {
            // 直接放行
            return chain.filter(exchange);
        }
        // 获取请求头中的token
        String token = null;
        List<String> headers = request.getHeaders().get("authorization");
        if (!CollUtils.isEmpty(headers))
        {
            token = headers.get(0);
        }
        // 校验并解析token
        Long userId;
        try
        {
            userId = jwtTool.parseToken(token);
        } catch (UnauthorizedException e)
        {
            ServerHttpResponse response = exchange.getResponse();
            response.setRawStatusCode(401);
            return response.setComplete();
        }
        // 如果有效，传递用户信息
        String userInfo = userId.toString();
        // 得到一个可执行的副本
        ServerWebExchange ex = exchange.mutate()
                .request(b -> b.header("user-info", userInfo))
                .build();
        // 放行
        return chain.filter(ex);
    }

    @Override
    public int getOrder()
    {
        return 0;
    }

    private boolean isExclude(String antPath)
    {
        for (String excludePath : authProperties.getExcludePaths())
        {
            if (antPathMatcher.match(excludePath, antPath))
            {
                return true;
            }
        }
        return false;
    }

}
