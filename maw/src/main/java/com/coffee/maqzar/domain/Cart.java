package com.coffee.maqzar.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public class Cart implements Serializable{

    private Long id;
    private List<CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart(Long id){
        this.id = id;
    }

    public CartItem getItemByProductId(Long productId){
        return cartItems.stream().filter(cartItem -> cartItem.getProduct().getProductId().equals(productId)).findAny().orElse(null);
    }

    public void updateGrandTotal(){
        Function<CartItem, BigDecimal> totalMapper = cartItem -> cartItem.getTotalPrice();

        BigDecimal grandTotal = cartItems.stream().map(totalMapper).reduce(BigDecimal.ZERO,BigDecimal::add);

        this.setGrandTotal(grandTotal);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 :
                id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }
}
