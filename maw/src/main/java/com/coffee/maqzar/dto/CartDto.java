package com.coffee.maqzar.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public class CartDto implements Serializable {

    private Long id;
    private List<CartItemDto> cartItems;

    public CartDto(){

    }

    public CartDto(Long id){
        this.id = id;
        cartItems = new ArrayList<CartItemDto>();
    }

    public void addCartItem(CartItemDto cartItemDto){
        this.cartItems.add(cartItemDto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }
}
