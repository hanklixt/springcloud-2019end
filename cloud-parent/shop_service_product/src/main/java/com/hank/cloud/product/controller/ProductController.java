package com.hank.cloud.product.controller;

import com.hank.cloud.product.entity.Product;
import com.hank.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Value("${server.port}")
	private String port;

	@Value("${spring.cloud.client.ip-address}") //spring cloud 自动的获取当前应用的ip地址
	private String ip;

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//
//
//		}
		if (id.equals(2L)){
			throw new RuntimeException("人为制造异常");
		}
		Product product = productService.findById(id);
		product.setProductName("访问的服务地址:"+ip + ":" + port);
		return product;
	}


	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(@RequestBody Product product) {
		productService.save(product);
		return "保存成功";
	}
}
