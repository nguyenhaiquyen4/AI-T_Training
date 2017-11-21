package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Product getProductById(String productID);

    List<Product> filterProducts(String brand, Map<String, String> filterPrice, String productCategory);
}
