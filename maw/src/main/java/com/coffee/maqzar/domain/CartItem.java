package com.coffee.maqzar.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public class CartItem implements Serializable{

    private Long id;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;


    public CartItem(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void updateTotalPrice(){
        this.totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        updateTotalPrice();
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        CartItem other = (CartItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
