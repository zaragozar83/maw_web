package com.coffee.maqzar.repository.impl;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.domain.CartItem;
import com.coffee.maqzar.domain.Product;
import com.coffee.maqzar.dto.CartDto;
import com.coffee.maqzar.dto.CartItemDto;
import com.coffee.maqzar.repository.ICartRepository;
import com.coffee.maqzar.service.IProductService;
import com.coffee.maqzar.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
@Repository
public class CartRepositoryImpl implements ICartRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTempleate;

    @Autowired
    private IProductService productService;

    @Override
    public void createCart(CartDto cartDto) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", cartDto.getId());

        String query = "INSERT INTO C (ID) values (:id)";

        jdbcTempleate.update(query,params);

        cartDto.getCartItems().stream().forEach(cartItemDto -> {

            Product productById = productService.getProductById(cartItemDto.getProductId());

            Map<String, Object> paramsInsert = new HashMap<String, Object>();
            paramsInsert.put("id", cartItemDto.getId());
            paramsInsert.put("productId", productById.getProductId());
            paramsInsert.put("cartId", cartDto.getId());
            paramsInsert.put("quantity", cartItemDto.getQuantity());

            String queryInsertCartItem = "INSERT INTO C_ITEM (ID, PRODUCT_ID, CART_ID, QUANTITY) values (:id, :productId, :cartId, :quantity)";

            jdbcTempleate.update(queryInsertCartItem, paramsInsert);
        });
    }

    @Override
    public Cart read(Long id) {
        String SQL = "SELECT * FROM C WHERE ID = :id";
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("id", id);
        CartMapper cartMapper = new CartMapper(jdbcTempleate, (ProductServiceImpl) productService);

        try {
            return jdbcTempleate.queryForObject(SQL,
                    params, cartMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Long id, CartDto cartDto) {
        List<CartItemDto> cartItems = cartDto.getCartItems();
        for(CartItemDto cartItem :cartItems) {
            String query = "UPDATE C_ITEM SET QUANTITY = :quantity, PRODUCT_ID = :productId WHERE ID = :id AND CART_ID = :cartId";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", cartItem.getId());
            params.put("quantity", cartItem.getQuantity());
            params.put("productId", cartItem.getProductId());
            params.put("cartId", id);

            jdbcTempleate.update(query, params);
        }
    }

    @Override
    public void delete(Long id) {
        String queryDeleteCartItem = "DELETE FROM C_ITEM WHERE CART_ID = :id";
        String queryDeleteCart = "DELETE FROM C WHERE ID = :id";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        jdbcTempleate.update(queryDeleteCartItem, params);
        jdbcTempleate.update(queryDeleteCart, params);

    }

    private Integer getLastIdCart(){
        Integer lastId = null;

        Map<String, Object> params = new HashMap<String, Object>();

        String query = "SELECT MAX(ID) FROM C";


        lastId = jdbcTempleate.queryForObject(query, params, Integer.class);

        return lastId;
    }

    @Override
    public Integer addItem(Long productId) {

        String query=null;
        Cart cart = null;

        Integer lastIdCart = getLastIdCart();
        if(lastIdCart != null){
            cart = read(Long.valueOf(lastIdCart));
        }else{
            lastIdCart = 1;
        }

        Map<String, Object> cartItemsParams = new HashMap<String, Object>();

        if(cart == null) {

            String queryInsertC = "INSERT INTO C (ID) VALUES (:id)";
            Map<String, Object> paramsInsertC = new HashMap<String, Object>();
            paramsInsertC.put("id", lastIdCart);
            jdbcTempleate.update(queryInsertC, paramsInsertC);

            cart = read(Long.valueOf(lastIdCart));
        }

            if(cart.getItemByProductId(productId) == null) {
                query = "INSERT INTO C_ITEM (PRODUCT_ID, CART_ID, QUANTITY) VALUES (:productId, :cartId, :quantity)";
                cartItemsParams.put("productId", productId);
                cartItemsParams.put("cartId", lastIdCart);
                cartItemsParams.put("quantity", 1);
            } else {
                query = "UPDATE C_ITEM SET QUANTITY = :quantity WHERE CART_ID = :cartId AND PRODUCT_ID = :productId";
                CartItem existingItem = cart.getItemByProductId(productId);
                cartItemsParams.put("id", existingItem.getId());
                cartItemsParams.put("quantity", existingItem.getQuantity()+1);
            }

        jdbcTempleate.update(query, cartItemsParams);

        return lastIdCart;
    }

    @Override
    public void removeItem(Long cartId, Long productId) {
        String query = "DELETE FROM C_ITEM WHERE PRODUCT_ID = :productId AND CART_ID = :id";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", cartId);
        params.put("productId", productId);

        jdbcTempleate.update(query, params);
    }
}
