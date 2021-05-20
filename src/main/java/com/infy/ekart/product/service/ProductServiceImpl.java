package com.infy.ekart.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.ekart.product.dto.ProductDTO;
import com.infy.ekart.product.entity.Product;
import com.infy.ekart.product.exception.ProductException;
import com.infy.ekart.product.repository.ProductRepository;


@Service(value = "productService")
@Transactional
public class ProductServiceImpl{
	
	@Autowired
	Environment env;
	
	@Autowired
	private ProductRepository productRepository;

	
	public List<ProductDTO> getProductsByName(String productName) throws ProductException{
		
		List<Product> productFromDB = productRepository.findByProductName(productName);
		
		if(productFromDB.isEmpty()) {
			//env.getProperty("Service.Product_Absent");
		throw new ProductException("Service.Product_Absent");
		}
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(Product pd : productFromDB) {
			ProductDTO dto = valueOf(pd);
			
			
			productDTOList.add(dto);
		}
		

		
		return productDTOList;
	}

	
	public List<ProductDTO> getProductsByCategory(String category) throws ProductException {

		List<Product> productFromDB = productRepository.findByCategory(category);
		
		if(productFromDB.isEmpty()) {
			throw new ProductException("No product of this name present");
		}
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(Product pd : productFromDB) {
			ProductDTO dto = valueOf(pd);
			
			productDTOList.add(dto);
		}

		return productDTOList;
	}

	
	public List<ProductDTO> getProducts() throws ProductException {
		
List<Product> productFromDB = (List<Product>) productRepository.findAll();
		
		if(productFromDB.isEmpty()) {
			throw new ProductException("No product of this name present");
		}
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(Product pd : productFromDB) {
			ProductDTO dto = valueOf(pd);
			
			productDTOList.add(dto);
		}
		

		
		return productDTOList;
	}

	
	public ProductDTO getProductById(Integer prodId) throws ProductException {
		Product pd = productRepository.findByProdId(prodId);
		
		if(pd==null) {
			//env.getProperty("Service.Product_Absent");
		throw new ProductException("Service.Product_Absent");
		}
			ProductDTO dto =valueOf(pd);
		return dto;
	}
	
	public static ProductDTO valueOf(Product products) {
		ProductDTO pd = new ProductDTO();
		pd.setCategory(products.getCategory());
		pd.setDescription(products.getDescription());
		pd.setImage(products.getImage());
		pd.setPrice(products.getPrice());
		pd.setProdId(products.getProdId());
		pd.setProductName(products.getProductName());
		pd.setProductRating(products.getProductRating());
		pd.setSellerId(products.getSellerId());
		pd.setStock(products.getStock());
		pd.setSubCategory(products.getSubCategory());
		return pd;
	}
	
	public static Product addP(ProductDTO th) {
		Product pd=new Product();
		pd.setCategory(th.getCategory());
		pd.setDescription(th.getDescription());
		pd.setImage(th.getImage());
		pd.setPrice(th.getPrice());
		pd.setProdId(th.getProdId());
		pd.setProductName(th.getProductName());
		pd.setProductRating(th.getProductRating());
		pd.setSellerId(th.getSellerId());
		pd.setStock(th.getStock());
		pd.setSubCategory(th.getSubCategory());
		return pd;
	}
	
	public String addProduct(ProductDTO productDTO) throws ProductException{
		
		Product productEntity = addP(productDTO);
		
		productRepository.save(productEntity);
		
		return productEntity.getProductName();
		
	}
}
