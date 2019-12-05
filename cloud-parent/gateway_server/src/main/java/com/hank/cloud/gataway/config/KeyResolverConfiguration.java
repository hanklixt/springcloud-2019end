package com.hank.cloud.gataway.config;

import cn.hutool.core.util.StrUtil;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-05 13:20
 */
@Configuration
public class KeyResolverConfiguration {

    /**
     * 本机IP
     */
    public static final String LOCAL_HOST_IP = "127.0.0.1";

    /**
     *
     */
    public static final String LOCALHOST_HOST_IP_0 = "0:0:0:0:0:0:0:1";
    /**
     * 根据请求路径进行限流
     * @return
     */
    @Bean
    public KeyResolver pathKeyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

//    /***
//     * 基于参数的限流
//     * @return
//     */
//    @Bean
//    public  KeyResolver paramsKeyResolver(){
//        return new KeyResolver() {
//            @Override
//            public Mono<String> resolve(ServerWebExchange exchange) {
//                return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//            }
//        };
//    }

//    /***
//     * 基于ip的限流
//     * @return
//     */
//    @Bean
//    public  KeyResolver ipKeyResolver(){
//
//
//
//        return new KeyResolver() {
//            @Override
//            public Mono<String> resolve(ServerWebExchange exchange) {
//                //涉及nginx等其他转发，代理等方式请求时，获取请求真实ip地址需要百度和自行测试
//                return Mono.just(exchange.getRequest().getHeaders().getFirst("X-forwarded-for"));
//            }
//        };
//    }
}
