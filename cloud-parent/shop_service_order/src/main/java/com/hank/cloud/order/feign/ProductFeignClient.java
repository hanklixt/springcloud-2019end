package com.hank.cloud.order.feign;

import com.hank.cloud.order.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-03 15:08
 */
@FeignClient(value = "service-product",fallback =ProductFeignClientImpl.class )
public interface ProductFeignClient {
    @GetMapping("/product/${id}")
    public Product findById(@PathVariable Long id);
}
