package com.hank.cloud.gataway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-05 13:20
 */
@Configuration
public class KeyResolverConfiguration {

    /**
     * 根据请求路径进行限流
     * @return
     */
    @Bean
    public KeyResolver keyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

    /***
     * 基于参数的限流
     * @return
     */
    @Bean
    public  KeyResolver paramsKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
            }
        };
    }

    /***
     * 基于参数的限流
     * @return
     */
    @Bean
    public  KeyResolver ipKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
            }
        };
    }
}
