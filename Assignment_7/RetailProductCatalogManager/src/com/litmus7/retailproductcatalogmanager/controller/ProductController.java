package com.litmus7.retailproductcatalogmanager.controller;

import com.litmus7.retailproductcatalogmanager.dto.*;
import com.litmus7.retailproductcatalogmanager.service.ProductService;

public class ProductController {
	private ProductService productService = new ProductService();
	
	public ProductResponse<Void> addProduct(Product product){
		ProductResponse<Void> response = new ProductResponse<>();
		try {
//			productService.addProduct(p);
		}
		catch() {}
	}
}
