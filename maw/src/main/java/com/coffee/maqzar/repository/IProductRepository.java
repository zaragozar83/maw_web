package com.coffee.maqzar.repository;

import com.coffee.maqzar.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
public interface IProductRepository {

    List<Product> getProducts();
    public Product getProductById(Long productId);
    void updateStock(long productId, long noUnits);
    public List<Product> getProductsByCategory(String category);
    public List<Product> getProductsByCategoryLike(String category);
    public List<Product> getProductsByCategoryAndPrice(Map<String, List<String>> params);
    public List<Product> getProductsByManufacturerAndPrice(String manufacturer, Long price);
    public List<Product> getProductsByCriterias(String category, BigDecimal minPrice, BigDecimal maxPrice, String manufacturer);
}
