package com.boot_crud.repository;

import com.boot_crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    public Product findById(int id);
    public Product deleteById(int id);
}
