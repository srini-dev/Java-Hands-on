package com.srini.service;

import com.srini.dao.CartDao;
import com.srini.model.MCart;
import com.srini.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public MCart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(MCart cart) {
        cartDao.update(cart);
    }
}
