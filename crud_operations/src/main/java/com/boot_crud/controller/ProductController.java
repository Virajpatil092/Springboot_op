package com.boot_crud.controller;

import com.boot_crud.entity.Product;
import com.boot_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/get")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @PutMapping("/edit/{id}")
    public Product editProduct(@PathVariable int id, @RequestBody Product product){
        return this.productService.updateProduct(id, product);
    }
}
