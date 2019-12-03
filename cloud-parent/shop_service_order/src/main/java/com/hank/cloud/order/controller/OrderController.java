package com.hank.cloud.order.controller;

import com.hank.cloud.order.entity.Product;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-03 9:24
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
/*
标准元数据：主机名、IP地址、端口号、状态页和健康检查等信息，这些信息都会被发布在服务注
册表中，用于服务之间的调用。
自定义元数据：可以使用eureka.instance.metadata-map配置，符合KEY/VALUE的存储格式。这
些元数据可以在远程客户端中访问。
在程序中可以使用DiscoveryClient 获取指定微服务的所有元数据信息
 */
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @GetMapping("/product/{id}")
     public Product productById(String id){
        Product forObject = restTemplate.getForObject("http://service-product/product/1", Product.class);
        return forObject;
    }

}
