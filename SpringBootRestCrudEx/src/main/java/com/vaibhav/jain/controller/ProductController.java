package com.vaibhav.jain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.jain.entity.Product;
import com.vaibhav.jain.exception.ProductNotFoundException;
import com.vaibhav.jain.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired(required = true)
	private IProductService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createProduct(
			@RequestBody Product product){
		Integer id =service.savProducts(product);
		String message = "Product Created with Id :-" +id;
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct(){
		List <Product> list = service.findAllProducts();
		return new ResponseEntity<List<Product>>(
				list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchOneProduct(@PathVariable Integer id){
		ResponseEntity<?> resp = null;
		
		try {
			Product prod = service.findOneProduct(id);
			resp = new ResponseEntity<Product>(
					prod, HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		
		ResponseEntity<String> resp = null;
		try {
			service.deleteProduct(id);
			resp = new ResponseEntity<String>("Product Deleted :-" + id, HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	@PatchMapping("/update/vendor/{proVendor}/{id}")
	public ResponseEntity<String> updateProductVendor(
			@PathVariable String proVendor,@PathVariable Integer id){
			ResponseEntity<String> resp = null;
			try {
				service.updateProductVendor(proVendor, id);
				resp = new ResponseEntity<String>(
						"Product Vendor Updated ", HttpStatus.OK);
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
				resp = new ResponseEntity<String>(
						e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return resp;
	}
}

