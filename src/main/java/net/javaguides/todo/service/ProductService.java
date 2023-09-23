package net.javaguides.todo.service;



import net.javaguides.todo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
