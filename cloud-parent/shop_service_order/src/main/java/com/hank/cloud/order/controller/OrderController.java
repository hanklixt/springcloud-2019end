package com.hank.cloud.order.controller;

import com.hank.cloud.order.entity.Product;
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

    @GetMapping("/product/{id}")
     public Product productById(String id){
        Product forObject = restTemplate.getForObject("http://localhost:9091/product/1", Product.class);
        return forObject;
    }

}
