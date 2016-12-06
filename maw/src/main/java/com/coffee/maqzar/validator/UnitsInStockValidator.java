package com.coffee.maqzar.validator;

import com.coffee.maqzar.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Created by exrzaragoza on 05/12/2016.
 */
public class UnitsInStockValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        if(product.getUnitPrice() != null
                && new BigDecimal(1000).compareTo(product.getUnitPrice()) <= 0
                && product.getUnitsInStock() > 99){
            errors.rejectValue("unitsInStock", "validator.unitsInStockValidator.message");
        }
    }
}
