package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class CreateProductRequest 
{
	String transactionId;
	Product parameters[];
	public boolean validate()
	{
		if (transactionId == null || transactionId == "" || transactionId.length() > 20) 
			return false;
		if (parameters == null || parameters.length == 0)
			return false;
		for (Product p : parameters)
		{
			if (p.validate() == false)
				return false;
		}
		return true;
	}
}
