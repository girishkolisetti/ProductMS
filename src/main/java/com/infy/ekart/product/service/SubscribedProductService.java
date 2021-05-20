package com.infy.ekart.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.ekart.product.dto.SubscribedProductDTO;
import com.infy.ekart.product.entity.SubscribedProduct;
import com.infy.ekart.product.repository.SubscribedProductRepository;


@Service
public class SubscribedProductService {
	@Autowired
	private SubscribedProductRepository spRepo;
	
	
	public String addNewSubscribedProduct(SubscribedProductDTO sptDto) {
		
		SubscribedProduct spd= new SubscribedProduct();
		spd.setBuyerId(sptDto.getBuyerId());
		spd.setProdId(sptDto.getProdId());
		spd.setQuantity(sptDto.getQuantity());
		spRepo.save(spd);
		return "saved";
	}


	public List<SubscribedProductDTO> getSubscribedProductId() {
		// TODO Auto-generated method stub
		Iterable<SubscribedProduct> s=spRepo.findAll();
		List<SubscribedProductDTO> spDto = new ArrayList<>();
		s.forEach(sp -> {
			SubscribedProductDTO p=new SubscribedProductDTO();
			p.setBuyerId(sp.getBuyerId());
			p.setProdId(sp.getProdId());
			p.setQuantity(sp.getQuantity());
			spDto.add(p);
		});
		return spDto;
	}

	
	
}
