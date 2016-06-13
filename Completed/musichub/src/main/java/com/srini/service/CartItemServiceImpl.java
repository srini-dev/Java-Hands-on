package com.srini.service;

import com.srini.dao.CartItemDao;
import com.srini.model.MCart;
import com.srini.model.MCartItem;
import com.srini.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(MCartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(MCartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(MCart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public MCartItem getCartItemByItemId (int itemId) {
        return cartItemDao.getCartItemByItemId(itemId);
    }
}
