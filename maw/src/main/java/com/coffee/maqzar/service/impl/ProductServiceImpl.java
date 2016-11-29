package com.coffee.maqzar.service.impl;

import com.coffee.maqzar.domain.Product;
import com.coffee.maqzar.repository.IProductRepository;
import com.coffee.maqzar.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public void updateAllProducts() {
        List<Product> listProducts = productRepository.getProducts();
        for(Product p : listProducts){
            if(p.getUnitsInStock() < 500){
                productRepository.updateStock(p.getProductId(), p.getUnitsInStock() + 1000);
            }
        }
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByCategoryLike(String category) {
        return productRepository.getProductsByCategoryLike(category);
    }

    @Override
    public List<Product> getProductsByCategoryAndPrice(Map<String, List<String>> params) {

        return productRepository.getProductsByCategoryAndPrice(params);
    }

    @Override
    public List<Product> getProductsByManufacturerAndPrice(String manufacturer, Long price) {
        return productRepository.getProductsByManufacturerAndPrice(manufacturer, price);
    }

    @Override
    public List<Product> getProductsByCriterias(String category, Map<String, List<String>> filterPrice, String manufacturer) {
        BigDecimal minPrice = new BigDecimal(0);
        BigDecimal maxPrice = new BigDecimal(0);

        if(filterPrice != null
                && filterPrice.containsKey("minPrice")
                && filterPrice.containsKey("maxPrice")) {
            for (Map.Entry<String, List<String>> entry : filterPrice.entrySet()) {
                System.out.println("entry.getKey(): " + entry.getKey() + " - entry.getValue(): " + entry.getValue());
                List<String> tempListPrice = entry.getValue();
                System.out.println("tempListPrice.get(0): "+ tempListPrice.get(0));
                switch (entry.getKey()) {
                    case "minPrice":
                        minPrice = new BigDecimal(tempListPrice.get(0));
                        break;
                    case "maxPrice":
                        maxPrice = new BigDecimal(tempListPrice.get(0));
                        break;
                    default:
                        break;
                }
            }
        }

        return productRepository.getProductsByCriterias(category, minPrice, maxPrice, manufacturer);
    }
}
