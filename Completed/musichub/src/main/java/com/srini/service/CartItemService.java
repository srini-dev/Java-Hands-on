package com.srini.service;

import com.srini.model.MCart;
import com.srini.model.MCartItem;


public interface CartItemService {

    void addCartItem(MCartItem cartItem);

    void removeCartItem(MCartItem cartItem);

    void removeAllCartItems(MCart cart);

    MCartItem getCartItemByItemId (int itemId);
}
