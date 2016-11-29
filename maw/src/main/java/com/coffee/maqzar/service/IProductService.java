package com.coffee.maqzar.service;

import com.coffee.maqzar.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
public interface IProductService {

    public List<Product> getProducts();
    public void updateAllProducts();
    public Product getProductById(Long productId);
    public List<Product> getProductsByCategory(String category);
    public List<Product> getProductsByCategoryLike(String category);
    public List<Product> getProductsByCategoryAndPrice(Map<String, List<String>> params);
    public List<Product> getProductsByManufacturerAndPrice(String manufacturer, Long price);
    public List<Product> getProductsByCriterias(String category, Map<String, List<String>> filterPrice, String manufacturer);
}
