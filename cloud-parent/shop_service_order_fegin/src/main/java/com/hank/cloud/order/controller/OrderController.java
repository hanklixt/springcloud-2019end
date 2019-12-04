package com.hank.cloud.order.controller;

import com.hank.cloud.order.entity.Product;
import com.hank.cloud.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-03 9:24
 */
@RestController
/**
 * @DefaultProperties 统一指定该类下的hystrix熔断方法，
 */
public class OrderController {


    @Autowired
    private ProductFeignClient feignClient;

    @GetMapping("/productfegin/{id}")
    public Product productByIdFegin(@PathVariable Long id){
        Product forObject = feignClient.findById(id);
        return forObject;
    }


    /**
     *  ！！！！统一的熔断方法，不能带参数
     * @return
     */
    public Product defaultFallback(){
        Product product = new Product();
        product.setProductName("统一的fallback");
        return product;
    }

    /**
     * 单个fallBack参数要保持一致
     * @param id
     * @return
     */
    public Product fallback(String id){
        Product product = new Product();
        product.setProductName("fallback");
        return product;
    }



}
