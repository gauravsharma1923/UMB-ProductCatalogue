package com.indosat.productcatalogue.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indosat.productcatalogue.pojo.CreateProductRequest;
import com.indosat.productcatalogue.pojo.DeleteProductRequest;
import com.indosat.productcatalogue.pojo.ListProductRequest;
import com.indosat.productcatalogue.pojo.Response;
import com.indosat.productcatalogue.pojo.UpdateProductRequest;
import com.indosat.productcatalogue.service.ProductService;

@RestController
@RequestMapping("/Products")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@PostMapping(value = "/List", consumes = "application/json")
	public Response list(@RequestBody ListProductRequest listProductRequest)
	{
		return productService.list(listProductRequest);
	}
	
	@PostMapping(value = "/Create", consumes = "application/json")
	public Response create(@RequestBody CreateProductRequest createProductRequest)
	{
		return productService.create(createProductRequest);
	}
	
	@PostMapping(value = "/Update", consumes = "application/json")
	public Response update(@RequestBody UpdateProductRequest updateProductRequest)
	{
		return productService.update(updateProductRequest);
	}
	
	@PostMapping(value = "/Delete", consumes = "application/json")
	public Response delete(@RequestBody DeleteProductRequest deleteProductRequest)
	{
		return productService.delete(deleteProductRequest);
	}
}
