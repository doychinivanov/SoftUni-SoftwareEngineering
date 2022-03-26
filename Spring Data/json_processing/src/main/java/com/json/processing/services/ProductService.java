package com.json.processing.services;

import com.json.processing.entities.categories.CategoryStatDTO;
import com.json.processing.entities.products.Product;
import com.json.processing.entities.products.ProductWithNoBuyerDTO;

import java.util.List;

public interface ProductService {
    List<ProductWithNoBuyerDTO> getProductsWithNoBuyer(float from, float to);

    List<CategoryStatDTO> getCategoryStats();
}
