package top.rectorlee.limit;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Lee
 * @description
 * @date 2023-05-11  15:34:10
 */
@Component
public class PathKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().toString();
        return Mono.just(path);
    }
}
