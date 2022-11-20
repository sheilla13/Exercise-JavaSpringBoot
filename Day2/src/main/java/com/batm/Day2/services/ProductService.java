package com.batm.Day2.services;

import com.batm.Day2.entities.Product;

import java.util.List;

public interface ProductService {
    public boolean saveProduct(Product product);
    public List<Product> findAllProducts();
    public Product findProductById(int id);
    public boolean deleteProductById(int id);
}