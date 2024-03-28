package com.product.service;

import com.product.entity.Product;
import com.product.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;

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
        Optional<Product> optionalProduct = Optional.ofNullable(this.productRepo.findById(id));
        return optionalProduct.orElse(null);
    }

    public void deleteProduct(int id){
        this.productRepo.deleteById(id);
    }

    public Product updateProduct(int id, Product updatedProduct){
        Optional<Product> optionalExistingProduct = Optional.ofNullable(productRepo.findById(id));

        if (optionalExistingProduct.isPresent()) {
            // Update fields of the existing product with the new data
            Product existingProduct = optionalExistingProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            // ... other fields

            // Save the updated product
            return productRepo.save(existingProduct);
        } else {
            // Handle the case where the product with the given ID is not found
            return null; // Or throw an exception
        }
    }
}
