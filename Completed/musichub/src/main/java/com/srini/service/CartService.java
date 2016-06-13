package com.srini.service;

import com.srini.model.MCart;


public interface CartService {

    MCart getCartById (int cartId);

    void update(MCart cart);
}
