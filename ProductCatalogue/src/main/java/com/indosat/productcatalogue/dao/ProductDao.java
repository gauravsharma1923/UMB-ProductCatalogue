package com.indosat.productcatalogue.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.indosat.productcatalogue.pojo.CreateProductRequest;
import com.indosat.productcatalogue.pojo.ListProductRequest;
import com.indosat.productcatalogue.pojo.Product;
import com.indosat.productcatalogue.pojo.ProductCategory;
import com.indosat.productcatalogue.pojo.ProductResponse;
import com.indosat.productcatalogue.pojo.Response;

@Repository
public class ProductDao 
{
	public List<Product> list(ProductCategory productCategory, EntityManager manager)
	{
		Query q1 = manager.createQuery("select p from Product p where ProductCategory = '" + productCategory.getProductCategory() + "'");
		List<Product> results = (List<Product>) q1.getResultList();
		return results;
	}
	
	public ProductResponse create(Product product, EntityManager manager)
	{
		ProductResponse resp = new ProductResponse(product.getProductId());
		try
		{
			manager.persist(product);
			resp.setErrorDesc("SUCCESS");
			resp.setErrorCode("0");
		}
		catch (EntityExistsException ex)
		{
			resp.setErrorDesc("Duplicate Entry");
			resp.setErrorCode("102");
		}
		catch (Exception ex)
		{
			resp.setErrorDesc("Internal Error");
			resp.setErrorCode("104");
		}
		return resp;
	}
	
	public ProductResponse update(Product product, EntityManager manager)
	{
		ProductResponse resp = new ProductResponse(product.getProductId());
		try
		{
			Product p = manager.find(Product.class, product.getProductId());
			if (p != null)
			{
				p.update(product);
				resp.setErrorDesc("SUCCESS");
				resp.setErrorCode("0");
			}
			else
			{
				resp.setErrorDesc("Identifier Not Found");
				resp.setErrorCode("101");
			}
		}
		catch (Exception ex)
		{
			resp.setErrorDesc("Internal Error");
			resp.setErrorCode("104");
		}
		return resp;
	}
	
	public ProductResponse delete(String productId, EntityManager manager)
	{
		ProductResponse resp = new ProductResponse(productId);
		try
		{
			Product p = manager.find(Product.class, productId);
			if (p != null)
			{
				manager.remove(p);
				resp.setErrorDesc("SUCCESS");
				resp.setErrorCode("0");
			}
			else
			{
				resp.setErrorDesc("Identifier Not Found");
				resp.setErrorCode("101");
			}
		}
		catch (Exception ex)
		{
			resp.setErrorDesc("Internal Error");
			resp.setErrorCode("104");
		}
		return resp;
	}
}
