package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class ListProductRequest 
{
	String transactionId;
	ProductCategory parameters;
	public boolean validate()
	{
		if (transactionId == null || transactionId == "" || transactionId.length() > 20) 
			return false;
		if (parameters == null || parameters.validate() == false)
			return false;
		return true;
	}
}
