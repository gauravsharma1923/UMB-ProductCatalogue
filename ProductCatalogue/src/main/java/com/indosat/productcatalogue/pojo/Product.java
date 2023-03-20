package com.indosat.productcatalogue.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.util.regex.*;

@Data
@Entity
@Table(name = "Product")
public class Product 
{
	@Id
	String ProductId;
	String ProductCategory;
	String ProductShortDesc;
	String ProductLongDesc;
	String ProductConfirmMessage;
	String Keyword;
	String SC;
	String RuleCheckFlag;
	String RuleCheckExpiryDate;
	String StartDate;
	String EndDate;
	
	public boolean validate()
	{
		if (ProductId == null || ProductId == "" || ProductId.length() > 32)
			return false;
		if (ProductCategory == null || ProductCategory == "" || ProductCategory.length() > 10)
			return false;
		if (ProductShortDesc == null || ProductShortDesc == "" || ProductShortDesc.length() > 40)
			return false;
		if (ProductLongDesc == null || ProductLongDesc == "" || ProductLongDesc.length() > 80)
			return false;
		if (ProductConfirmMessage == null || ProductConfirmMessage == "" || ProductConfirmMessage.length() > 40)
			return false;
		if (Keyword == null || Keyword == "" || Keyword.length() > 30)
			return false;
		if (SC == null || SC == "" || SC.length() > 30)
			return false;
		if (RuleCheckFlag == null || RuleCheckFlag == "" || (RuleCheckFlag != "0" && RuleCheckFlag != "1"))
			return false;
		
		Pattern pattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))", Pattern.CASE_INSENSITIVE);
		if (RuleCheckExpiryDate == null || RuleCheckExpiryDate == "" || pattern.matcher(RuleCheckExpiryDate).find() == false)
			return false;
		if (StartDate == null || StartDate == "" || pattern.matcher(StartDate).find() == false)
			return false;
		if (EndDate == null || EndDate == "" || pattern.matcher(EndDate).find() == false)
			return false;
		
		return true;
	}
	
	public boolean update(Product p)
	{
		if (p.getProductId() == ProductId)
		{
			ProductCategory = p.getProductCategory();
			ProductShortDesc = p.getProductShortDesc();
			ProductLongDesc = p.getProductLongDesc();
			ProductConfirmMessage = p.getProductConfirmMessage();
			Keyword = p.getKeyword();
			SC = p.getSC();
			RuleCheckFlag = p.getRuleCheckFlag();
			RuleCheckExpiryDate = p.getRuleCheckExpiryDate();
			StartDate = p.getStartDate();
			EndDate = p.getEndDate();
			return true;
		}
		else
		{
			return false;
		}
	}
}
