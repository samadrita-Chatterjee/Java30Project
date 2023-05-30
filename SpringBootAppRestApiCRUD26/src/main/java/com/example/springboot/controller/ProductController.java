package com.example.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepository;
import com.example.springboot.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private ProductService productService ;
	
	public  ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	//build create product 	REST API
	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	// build get all products REST API
		@GetMapping
		public List<Product> getAllProduct(){
			return productService.getAllProduct();
		}
		
		// build get products by id REST API
		// http://localhost:8080/api/products/1
		@GetMapping("{id}")
		public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
			return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
		}
		
		// build update products REST API
		// http://localhost:8080/api/products/1
		@PutMapping("{id}")
		public ResponseEntity<Product> updateProduct(@PathVariable("id") long id
													  ,@RequestBody Product product){
			return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
		}
		
		// build delete product REST API
		// http://localhost:8080/api/products/1
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
			
			// delete product from DB
			productService.deleteProduct(id);
			
			return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
		}
		
	}
	


