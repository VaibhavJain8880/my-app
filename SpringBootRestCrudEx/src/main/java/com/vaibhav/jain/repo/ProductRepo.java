package com.vaibhav.jain.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaibhav.jain.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Product SET proVendor = ?1 WHERE id = ?2")
	int updateProductVendor(String proVendor, Integer id);
}
