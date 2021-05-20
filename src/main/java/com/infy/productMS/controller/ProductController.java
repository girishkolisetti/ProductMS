package com.infy.productMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.productMS.dto.ProductDTO;
import com.infy.productMS.dto.SubscribedProductDTO;
import com.infy.productMS.service.ProductService;
import com.infy.productMS.service.SubscribedProductService;

@RestController
@CrossOrigin
public class ProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	@Autowired
	SubscribedProductService spService;
	
	@GetMapping(value = "/product",  produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getVisitor() {
		logger.info("");
			return productService.visitor();
		
	}
	
	@GetMapping(value = "/product/category/{category}",  produces= MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> getSearchByCategory(@PathVariable String category) {
		logger.info("");
			return productService.searchByCategory(category);
	}
	
	
	@GetMapping(value = "/product/{pname}",  produces= MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getSearchByProductName(@PathVariable String pname) {
		logger.info("");
			return productService.searchByProductName(pname);
	}
	
	@PostMapping(value = "/product/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addNewProduct( @RequestBody ProductDTO pDTO) {
		
		return new ResponseEntity<>( productService.addNewProduct(pDTO),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/product/updatestock",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addStock(@RequestBody ProductDTO pDTO) {
		
		return new ResponseEntity<>( productService.addStock(pDTO),HttpStatus.OK);
	}
	@PostMapping(value = "/subscribedproduct/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addNewSubscribedProduct( @RequestBody SubscribedProductDTO spDTO) {
		
		return new ResponseEntity<>( spService.addNewSubscribedProduct(spDTO),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/subscribedproduct",  produces= MediaType.APPLICATION_JSON_VALUE)
	public List<SubscribedProductDTO> getSubscribedProduct() {
		logger.info("");
			return spService.getSubscribedProductId();
	}
}
