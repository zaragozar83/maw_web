package com.coffee.maqzar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by exrzaragoza on 01/12/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se encontraron productos con esta categoría")
public class NoProductsFoundUnderCategoryException extends RuntimeException {

    private static final Long serialVersionUID = 3935230281455340039L;
}
