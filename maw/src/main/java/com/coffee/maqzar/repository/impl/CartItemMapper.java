package com.coffee.maqzar.repository.impl;

import com.coffee.maqzar.domain.CartItem;
import com.coffee.maqzar.service.impl.ProductServiceImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public class CartItemMapper implements RowMapper<CartItem> {

    private ProductServiceImpl productService;

    public CartItemMapper(ProductServiceImpl productService){
        this.productService = productService;
    }

    @Override
    public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("ID");
        Long productId = rs.getLong("PRODUCT_ID");
        Long cartId = rs.getLong("CART_ID");
        int quantity = rs.getInt("QUANTITY");

        CartItem cartItem = new CartItem(id);

        cartItem.setProduct(this.productService.getProductById(productId));

        cartItem.setQuantity(rs.getInt("QUANTITY"));

        return cartItem;
    }

    public ProductServiceImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }
}
