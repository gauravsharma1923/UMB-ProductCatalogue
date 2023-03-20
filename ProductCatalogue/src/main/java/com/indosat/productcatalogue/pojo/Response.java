package com.indosat.productcatalogue.pojo;

import lombok.Data;

@Data
public class Response 
{
	String transactionId;
	String errorDesc;
	String errorCode;
	Object parameters;
	public Response(String transactionId)
	{
		this.transactionId = transactionId;
	}
}
