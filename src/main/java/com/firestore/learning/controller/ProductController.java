package com.firestore.learning.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firestore.learning.entity.Product;
import com.firestore.learning.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products/{name}")
	public Product getProduct(@PathVariable String name) throws InterruptedException, ExecutionException {
		return productService.getProductDetails(name);
	}
	@GetMapping("/products")
	public List<Product> getAllProduct() throws InterruptedException, ExecutionException {
		return productService.getAllProducts();
	}
	
	@PostMapping("/products")
	public String saveProduct(@RequestBody Product product) throws InterruptedException, ExecutionException {
		return productService.saveProduct(product);
	}
	
	@PutMapping("/products")
	public String updateProducts(@RequestBody Product product) throws InterruptedException, ExecutionException {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{name}")
	public String updateProducts(@PathVariable String name) throws InterruptedException, ExecutionException {
		return productService.deleteProduct(name);
	}
	
	
}
