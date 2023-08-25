package com.example.UserProductControl.services;

import com.example.UserProductControl.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> searchProductsByName(String name);

    ProductDTO getProductById(Long id);
}
