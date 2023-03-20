package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class DeleteProductRequest 
{
	String transactionId;
	ProductId parameters[];
	public boolean validate()
	{
		if (transactionId == null || transactionId == "" || transactionId.length() > 20) 
			return false;
		if (parameters == null || parameters.length == 0)
			return false;
		for (ProductId p : parameters)
		{
			if (p.validate() == false)
				return false;
		}
		return true;
	}
}
