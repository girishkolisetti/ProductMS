package com.infy.ekart.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.ekart.product.dto.ProductDTO;
import com.infy.ekart.product.dto.SubscribedProductDTO;
import com.infy.ekart.product.exception.ProductException;
import com.infy.ekart.product.service.ProductServiceImpl;
import com.infy.ekart.product.service.SubscribedProductService;

@RestController
@RequestMapping(value = "/Product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	

	@Autowired
	SubscribedProductService spService;
	
	@RequestMapping(value="/product/{productName}",method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getProductsByName(@PathVariable String productName) throws ProductException{
		
		List<ProductDTO> productFromDB = productService.getProductsByName(productName);
		
		return new ResponseEntity<List<ProductDTO>>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/category/{category}",method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) throws ProductException{
		
		List<ProductDTO> productFromDB = productService.getProductsByCategory(category);
		
		return new ResponseEntity<List<ProductDTO>>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getAllProducts()  throws ProductException{
		
		List<ProductDTO> productFromDB = productService.getProducts();
		
		return new ResponseEntity<List<ProductDTO>>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/productid/{prodId}",method=RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductsById(@PathVariable Integer prodId) throws ProductException{
		
		ProductDTO productFromDB = productService.getProductById(prodId);
		
		return new ResponseEntity<ProductDTO>(productFromDB,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/product/add",method=RequestMethod.POST)
	public ResponseEntity<String> addProductBySeller(@RequestBody ProductDTO product) throws ProductException{
		
		String productServ = productService.addProduct(product);
		
		String sm = productServ + " successfully added";
		
		return new ResponseEntity<>(sm, HttpStatus.OK);

		
	}
	

	@PostMapping(value = "/subscribedproduct/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> addNewSubscribedProduct( @RequestBody SubscribedProductDTO spDTO) {
		
		return new ResponseEntity<>( spService.addNewSubscribedProduct(spDTO),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/subscribedproduct",  produces= MediaType.APPLICATION_JSON_VALUE)
	public List<SubscribedProductDTO> getSubscribedProduct() {
		//logger.info("");
			return spService.getSubscribedProductId();
	}
	
}
