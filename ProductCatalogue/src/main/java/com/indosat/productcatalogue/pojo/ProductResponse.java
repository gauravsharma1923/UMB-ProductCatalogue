package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class ProductResponse 
{
	String ProductId;
	String errorDesc;
	String errorCode;
	public ProductResponse(String productId)
	{
		ProductId = productId;
	}
}
