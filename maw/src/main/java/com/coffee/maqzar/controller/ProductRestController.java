package com.coffee.maqzar.controller;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.domain.Product;
import com.coffee.maqzar.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
@RestController
@RequestMapping(value = "rest/product")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    //http://localhost:8080/maw/rest/product/1
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable(value = "productId") String productId) {
        return productService.getProductById(Long.valueOf(productId));
    }
}
