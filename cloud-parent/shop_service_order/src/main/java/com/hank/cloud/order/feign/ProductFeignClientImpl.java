package com.hank.cloud.order.feign;

import com.hank.cloud.order.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-03 15:36
 */
@Component
public class ProductFeignClientImpl implements  ProductFeignClient {
    @Override
    public Product findById(Long id) {
        Product product=new Product();
        product.setProductName("fallback");
        return product;
    }
}
