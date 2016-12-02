package com.coffee.maqzar.exception;

/**
 * Created by exrzaragoza on 01/12/2016.
 */
public class ProductNotFoundException extends RuntimeException {

    private String productId;

    public ProductNotFoundException(){

    }

    public ProductNotFoundException(String productId){
        this.setProductId(productId);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
