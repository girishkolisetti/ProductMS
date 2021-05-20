package com.infy.productMS.dto;

import javax.validation.constraints.Min;

import com.infy.productMS.entity.Product;

public class ProductDTO {
	private Integer prodId;
	private String productName;
	@Min(value = 200, message = "price should be minimum 200")
	private Float price;
	@Min(value = 10, message = "stock should be minimum 10")
	private Integer stock;
	private String description;
	private String image;
	private Integer sellerId;
	private String category;
	private String subCategory;
	private Integer productRating;
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public Integer getProductRating() {
		return productRating;
	}
	public void setProductRating(Integer productRating) {
		this.productRating = productRating;
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
	
}
