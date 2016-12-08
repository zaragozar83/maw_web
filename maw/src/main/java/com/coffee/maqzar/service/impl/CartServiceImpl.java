package com.coffee.maqzar.service.impl;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.dto.CartDto;
import com.coffee.maqzar.repository.ICartRepository;
import com.coffee.maqzar.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public void create(CartDto cartDto) {
        cartRepository.createCart(cartDto);
    }

    @Override
    public Cart read(Long cartId) {
        return cartRepository.read(cartId);
    }

    @Override
    public void update(Long cartId, CartDto cartDto) {
        cartRepository.update(cartId, cartDto);
    }

    @Override
    public void delete(Long id) {
        cartRepository.delete(id);
    }

    @Override
    public Integer addItem(Long productId) {
        return cartRepository.addItem(productId);
    }

    @Override
    public void removeItem(Long cartId, Long productId) {
        cartRepository.removeItem(cartId, productId);
    }
}
