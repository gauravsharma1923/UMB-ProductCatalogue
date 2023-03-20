package com.indosat.productcatalogue.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indosat.productcatalogue.dao.ProductDao;
import com.indosat.productcatalogue.pojo.CreateProductRequest;
import com.indosat.productcatalogue.pojo.DeleteProductRequest;
import com.indosat.productcatalogue.pojo.ListProductRequest;
import com.indosat.productcatalogue.pojo.Product;
import com.indosat.productcatalogue.pojo.ProductId;
import com.indosat.productcatalogue.pojo.ProductResponse;
import com.indosat.productcatalogue.pojo.Response;
import com.indosat.productcatalogue.pojo.UpdateProductRequest;

@Service
public class ProductService 
{
	@Autowired
	ProductDao productDao;
	
	public Response list(ListProductRequest listProductRequest)
	{
		Response response = new Response(listProductRequest.getTransactionId());
		if (listProductRequest.validate())
		{
			response.setErrorDesc("SUCCESS");
			response.setErrorCode("0");
			
			final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JavaHelps");
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			List<Product> l = productDao.list(listProductRequest.getParameters(), manager);
			
			response.setParameters(l);
		}
		else
		{
			response.setErrorDesc("Invalid Input Data");
			response.setErrorCode("103");
		}
		return response;
	}
	
	public Response create(CreateProductRequest createProductRequest)
	{
		Response response = new Response(createProductRequest.getTransactionId());
		if (createProductRequest.validate())
		{
			response.setErrorDesc("SUCCESS");
			response.setErrorCode("0");
			
			final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JavaHelps");
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			List<ProductResponse> l = new ArrayList<ProductResponse>();
			for (Product product : createProductRequest.getParameters())
			{
				ProductResponse pr = productDao.create(product, manager);
				l.add(pr);
			}
			response.setParameters(l);
			transaction.commit();
			manager.close();
		}
		else
		{
			response.setErrorDesc("Invalid Input Data");
			response.setErrorCode("103");
		}
		
		return response;
	}
	
	public Response update(UpdateProductRequest updateProductRequest)
	{
		Response response = new Response(updateProductRequest.getTransactionId());
		if (updateProductRequest.validate())
		{
			response.setErrorDesc("SUCCESS");
			response.setErrorCode("0");
			
			final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JavaHelps");
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			List<ProductResponse> l = new ArrayList<ProductResponse>();
			for (Product product : updateProductRequest.getParameters())
			{
				ProductResponse pr = productDao.update(product, manager);
				l.add(pr);
			}
			response.setParameters(l);
			transaction.commit();
			manager.close();
		}
		else
		{
			response.setErrorDesc("Invalid Input Data");
			response.setErrorCode("103");
		}
		
		return response;
	}
	
	public Response delete(DeleteProductRequest deleteProductRequest)
	{
		Response response = new Response(deleteProductRequest.getTransactionId());
		if (deleteProductRequest.validate())
		{
			response.setErrorDesc("SUCCESS");
			response.setErrorCode("0");
			
			final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JavaHelps");
			EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			List<ProductResponse> l = new ArrayList<ProductResponse>();
			for (ProductId productId : deleteProductRequest.getParameters())
			{
				ProductResponse pr = productDao.delete(productId.getProductId(), manager);
				l.add(pr);
			}
			response.setParameters(l);
			transaction.commit();
			manager.close();
		}
		else
		{
			response.setErrorDesc("Invalid Input Data");
			response.setErrorCode("103");			
		}
		return response;
	}
}
