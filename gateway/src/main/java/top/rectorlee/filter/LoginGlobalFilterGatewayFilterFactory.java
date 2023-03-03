package top.rectorlee.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Lee
 * @description
 * @date 2023-03-03  17:29:32
 */
@Component
public class LoginGlobalFilterGatewayFilterFactory implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求参数
        String token = exchange.getRequest().getQueryParams().getFirst("token");

        if (StringUtils.isEmpty(token)) {
            // 没有登陆,状态码设置为403
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);

            // 结束请求
            return exchange.getResponse().setComplete();
        }

        // 放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 定义过滤器的执行顺序,值越小越先执行
        return 0;
    }
}
