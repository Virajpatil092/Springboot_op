package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productService.getProduct(id);

        if (product != null) {
            model.addAttribute("product", product);
            return "productView";
        } else {
            // Handle the case where the product with the given ID is not found
            return "productNotFound";
        }
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable int id, Model model) {
        Product product = productService.getProduct(id);

        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct";
        } else {
            // Handle the case where the product with the given ID is not found
            return "productNotFound";
        }
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, @ModelAttribute Product updatedProduct) {
        Product updated = productService.updateProduct(id, updatedProduct);

        if (updated != null) {
            return "redirect:/list";
        } else {
            // Handle the case where the product with the given ID is not found
            return "productNotFound";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/list";
    }
}
