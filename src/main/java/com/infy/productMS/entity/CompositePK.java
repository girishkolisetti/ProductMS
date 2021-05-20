package com.infy.productMS.entity;
import java.io.Serializable;

public class CompositePK implements Serializable{

	private static final long serialVersionUID = 1L;
	private String buyerId;
	private String prodId;
	
	public CompositePK() {
	}

	public CompositePK(String buyerId, String prodId) {
		this.buyerId = buyerId;
		this.prodId = prodId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getProdId() {
		return prodId;
	}
}
