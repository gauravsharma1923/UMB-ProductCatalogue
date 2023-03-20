package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class ProductCategory 
{
	String ProductCategory;
	public boolean validate()
	{
		if (ProductCategory.length() > 10)
			return false;
		return true;
	}
}
