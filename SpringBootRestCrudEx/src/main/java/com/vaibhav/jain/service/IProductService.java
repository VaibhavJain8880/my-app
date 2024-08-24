package com.vaibhav.jain.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.vaibhav.jain.entity.Product;

@Repository
public interface IProductService {

	Integer savProducts(Product p);
	List<Product>findAllProducts();
	Product findOneProduct(Integer id);
	void deleteProduct(Integer id);
	void updateProduct(Product p);
	int updateProductVendor(String proVendor , Integer id);
}
