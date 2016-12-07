package com.coffee.maqzar.service;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.dto.CartDto;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public interface ICartService {

    void create(CartDto cartDto);

    Cart read(Long cartId);

    void update(Long cartId, CartDto cartDto);

    void delete(Long id);

    void addItem(Long productId);

    void removeItem(Long cartId, Long productId);
}
