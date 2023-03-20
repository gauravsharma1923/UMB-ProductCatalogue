package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class ProductId 
{
	String ProductId;
	public boolean validate()
	{
		if (ProductId == null || ProductId == "" || ProductId.length() > 32)
			return false;
		return true;
	}
}
