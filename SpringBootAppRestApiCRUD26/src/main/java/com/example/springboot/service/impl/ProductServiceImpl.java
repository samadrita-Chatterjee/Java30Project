package com.example.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepository;
import com.example.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository ;
	
	public  ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository =productRepository;
	}
	

	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}


	@Override
	public List<Product> getAllProduct() {
		
		return  productRepository.findAll();
	}


	@Override
	public Product getProductById(long id) {
		
		return productRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Product", "Id", id));
				
	}


	@Override
	public Product updateProduct(Product product, long id) {
		// we need to check whether product with given id is exist in DB or not
		Product existingProduct = productRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Product", "Id", id)); 
				
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
				// save existing product to DB
		productRepository.save(existingProduct);
		return existingProduct;
	}


	@Override
	public void deleteProduct(long id) {
		
		// check whether a product exist in a DB or not
		productRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Product", "Id", id));
		productRepository.deleteById(id);
	}

	
	}

	