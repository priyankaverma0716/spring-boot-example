package com.infosys.example.springbootexample.controller;

import com.infosys.example.springbootexample.exception.ProductNotFoundException;
import com.infosys.example.springbootexample.model.request.ProductRequest;
import com.infosys.example.springbootexample.model.response.ProductResponse;
import com.infosys.example.springbootexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);


    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        ProductResponse product = productService.getProduct(id);
        if(product == null)
            throw new  ProductNotFoundException("Product not found!");

        return product;
    }


    @GetMapping
    public List<ProductResponse> getProducts(@QueryParam("keyword") String keyword) {
        return productService.getProducts(keyword);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
}}