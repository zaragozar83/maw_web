package com.coffee.maqzar.repository.impl;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.domain.CartItem;
import com.coffee.maqzar.service.IProductService;
import com.coffee.maqzar.service.impl.ProductServiceImpl;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public class CartMapper implements RowMapper<Cart> {

    private CartItemMapper cartItemMapper;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public CartMapper(NamedParameterJdbcTemplate jdbcTemplate, ProductServiceImpl productService){
        this.jdbcTemplate = jdbcTemplate;
        cartItemMapper = new CartItemMapper(productService);
    }

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("ID");
        Cart cart = new Cart(id);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String query = "SELECT * FROM C_ITEM WHERE CART_ID = :id";

        List<CartItem> cartItems = jdbcTemplate.query(query, params, cartItemMapper);

        cart.setCartItems(cartItems);

        return cart;
    }
}
