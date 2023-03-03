package top.rectorlee.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author Lee
 * @description 自定义局部参数过滤器
 * @date 2023-03-03  17:02:16
 */
@Component
public class CustomLocationFilterOfParameterGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        GatewayFilter fg = new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpResponse response = exchange.getResponse();

                String name = config.getName();
                String value = config.getValue();
                System.out.println("name: " + name + "; value: " + value);

                if (!"Lee1".equals(value)) {
                    response.setStatusCode(HttpStatus.BAD_REQUEST);
                    DataBuffer buffer = response.bufferFactory().wrap("参数异常".getBytes(StandardCharsets.UTF_8));
                    return response.writeWith(Mono.just(buffer));
                }
                // 放行
                return chain.filter(exchange);
            }
        };

        // 定义过滤器执行顺序,数字越小越先执行
        return new OrderedGatewayFilter(fg, 2);
    }
}
