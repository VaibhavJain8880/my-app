package com.vaibhav.jain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaibhav.jain.entity.Product;
import com.vaibhav.jain.exception.ProductNotFoundException;
import com.vaibhav.jain.repo.ProductRepo;
import com.vaibhav.jain.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired(required = true)
	private ProductRepo repo;
	
	@Override
	public Integer savProducts(Product p) {
		repo.save(p);
		return p.getProId();
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> list = repo.findAll();
		return list;
	}

	@Override
	public Product findOneProduct(Integer id) {
		
		return repo.findById(id).orElseThrow(
				()->new ProductNotFoundException
				("Product Not Exist with id :-" +id));
	}

	@Override
	public void deleteProduct(Integer id) {
		//Product p =findOneProduct(id);
		repo.delete(findOneProduct(id));

	}

	@Override
	public void updateProduct(Product p) {
		if(p.getProId()!= null && 
				repo.existsById(p.getProId())) {
				repo.save(p);
		}else {
			throw new ProductNotFoundException(
					"Product not exist with id :-" +p.getProId());
		}

	}

	@Override
	@Transactional
	public int updateProductVendor(String vendor, Integer id) {
		if(id != null && repo.existsById(id)) {
			return repo.updateProductVendor(vendor, id);
		}else {
			throw new ProductNotFoundException("Product not exist with id :-" +id);
		}
	}

}
