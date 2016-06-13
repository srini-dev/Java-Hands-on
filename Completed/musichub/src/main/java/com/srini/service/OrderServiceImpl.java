package com.srini.service;

import com.srini.dao.OrderDao;
import com.srini.model.MCart;
import com.srini.model.MCartItem;
import com.srini.model.MUserOrder;
import com.srini.service.CartService;
import com.srini.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    public void addOrder(MUserOrder userOrder) {
    	orderDao.addOrder(userOrder);
    }

    public double getOrderGrandTotal(int cartId) {
        double grandTotal=0;
        MCart cart = cartService.getCartById(cartId);
        List<MCartItem> cartItems = cart.getCartItems();

        for (MCartItem item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }
}
