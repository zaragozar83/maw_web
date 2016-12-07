package com.coffee.maqzar.repository;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.dto.CartDto;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public interface ICartRepository {

    void createCart(CartDto cartDto);
    Cart read(Long id);
    void update (Long id, CartDto cartDto);
    void delete(Long id);
    void addItem(Long cartId, Long productId);
    void removeItem(Long cartId, Long productId);
}
