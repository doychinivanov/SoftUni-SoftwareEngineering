package com.json.processing.services;

import com.json.processing.entities.products.ProductWithNoBuyerDTO;

import java.util.List;

public interface ProductService {
    List<ProductWithNoBuyerDTO> getProductsWithNoBuyer(float from, float to);
}
