package com.coffee.maqzar.controller;

import com.coffee.maqzar.domain.Cart;
import com.coffee.maqzar.dto.CartDto;
import com.coffee.maqzar.service.ICartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by exrzaragoza on 06/12/2016.
 */
@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {

    Logger logger = Logger.getLogger(CartRestController.class);

    @Autowired
    private ICartService cartService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody CartDto cartDto){
        cartService.create(cartDto);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public Cart read(@PathVariable(value = "cartId") String cartId) {
        System.out.println("--> read, property cartId: " + cartId);
        logger.info("This is the method read, property cardId: " + cartId);

        return cartService.read(Long.valueOf(cartId));
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody CartDto cartDto) {
        cartDto.setId(Long.valueOf(cartId));
        cartService.update(Long.valueOf(cartId), cartDto);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(Long.valueOf(cartId));
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void addItem(@PathVariable String productId, HttpSession session) {
        cartService.addItem(Long.valueOf(productId));
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(@PathVariable String productId, HttpSession session) {
        cartService.removeItem(Long.valueOf(session.getId()), Long.valueOf(productId));
    }
}
