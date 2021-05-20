package com.infy.productMS.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.productMS.dto.ProductDTO;
import com.infy.productMS.entity.Product;
import com.infy.productMS.repository.ProductRepository;

@Service
public class ProductService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<ProductDTO> visitor(){
		Iterable<Product> product = productRepo.findAll();
		List<ProductDTO> pDto = new ArrayList<>();
		product.forEach(products -> {
			pDto.add(ProductDTO.valueOf(products));
		});
		if(pDto.isEmpty()) {
			logger.info("Empty list no products found in db");
		}
		return pDto;
	}
	
	public List<ProductDTO> searchByCategory(String category){
		Iterable<Product> product = productRepo.findByCategory(category);
		List<ProductDTO> pDto = new ArrayList<>();
		product.forEach(products -> {
			pDto.add(ProductDTO.valueOf(products));
		});
		if(pDto.isEmpty()) {
			logger.info("Empty list no products found in db");
		}
		return pDto;
	}
	
	public ProductDTO searchByProductName(String pname){
		Product product = productRepo.findByProductName(pname);
		ProductDTO pDto = ProductDTO.valueOf(product);

		if(pDto==null) {
			logger.info("Empty list no products found in db");
		}
		return pDto;
	}
	
	public String addStock(ProductDTO pDto) {
		String name=pDto.getProductName();
		int stock=pDto.getStock();
		if(stock<10) {
			return "stock should be atleast 10";
		}
		int olds;
		Product product = productRepo.findByProductName(name);
		olds=product.getStock();
		//product.setStock(olds+stock);
		ProductDTO p=ProductDTO.valueOf(product);
		p.setStock(olds+stock);
		productRepo.save(ProductDTO.addP(p));
		Product product1 = productRepo.findByProductName(name);
		if(product1.getStock()==olds+stock) {
			return "Updated";
		}
		return "updation failed";
		
	}
	
	public String addNewProduct(ProductDTO productDto) {
		if(productDto.getStock()<10) {
			return "stock should be atleast 10";
		}
		if(productDto.getPrice()<200) {
			return "price should be atleast 200";
		}
		else {
		Product pd=ProductDTO.addP(productDto);
		productRepo.save(pd);
		return "saved";
		}
	}
	
	
}
