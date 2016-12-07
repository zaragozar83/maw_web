package com.coffee.maqzar.dto;

import java.io.Serializable;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
public class CartItemDto implements Serializable {

    private Long id;
    private Long productId;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
