package com.hank.cloud.product.service;


import com.hank.cloud.product.entity.Product;

public interface ProductService {

	/**
	 * 根据id查询
	 */
	Product findById(Long id);

	/**
	 * 保存
	 */
	void save(Product product);
	/**
	 * 更新
	 */
	void update(Product product);
	/**
	 * 删除
	 */
	void delete(Long id);
}
