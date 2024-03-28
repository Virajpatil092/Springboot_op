package com.boot_crud.service;

import com.boot_crud.entity.Product;
import com.boot_crud.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product saveProduct(Product product){
        return this.productRepo.save(product);
    }

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    public Product getProduct(int id) {
        return this.productRepo.findById(id);
    }

    public Product deleteProduct(int id){
        return this.productRepo.deleteById(id);
    }

    public Product updateProduct(int id, Product product){
        productRepo.deleteById(id);
        return productRepo.save(product);
    }
}
