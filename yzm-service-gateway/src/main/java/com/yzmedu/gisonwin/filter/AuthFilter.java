package com.yzmedu.gisonwin.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

/**
 * Order,数字越小,优先级越高.
 * token验证过滤器.
 * 登录和注册在忽略验证的列表中.可配置.
 * 其他所有请求都走验证token的过滤器.
 *
 * @author <a href="mailto:gisonwin@qq.com">GisonWin</a>
 * @date 2020/4/6 17:46
 */
@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Value("${auth.skip.urls:skip urls not config yet}")
    private String[] skipAuthUrls; //忽略验证的urls

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath().trim();
        Assert.notEmpty(skipAuthUrls, "skip auth urls is not null");
        //如果当前路径不需要验证就放行
        if (Stream.of(skipAuthUrls).anyMatch(url -> url.equalsIgnoreCase(path.trim()))) {
            log.debug("{} 不需要鉴权,its order {}", path.trim(), getOrder());
            return chain.filter(exchange);
        }
        //TODO 获取客户端 传来的token信息进行安全鉴定
        //TODO 比如使用token去redis里查看是否过期,是否在黑名单 中等
        //TODO 验证通过后走过滤器链即可
        //TODO 验证未通过 直接返回客户端 相应的提示信息

        return chain.filter(exchange);
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return -100;
    }
}
