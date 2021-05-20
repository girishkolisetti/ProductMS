package com.infy.productMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.productMS.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Iterable<Product> findByCategory(String category);

	Product findByProductName(String pname);

	Product findByProdId(int id);

	
}
