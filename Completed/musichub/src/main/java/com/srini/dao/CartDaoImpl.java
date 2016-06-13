package com.srini.dao;

import com.srini.dao.CartDao;
import com.srini.model.MCart;
import com.srini.service.OrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;



@Repository
@Transactional
public class CartDaoImpl implements CartDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private OrderService orderService;

    public MCart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (MCart) session.get(MCart.class, cartId);
    }

    public void update(MCart cart) {
        int cartId = cart.getCartId();
        double grandTotal = orderService.getOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    public MCart validate(int cartId) throws IOException {
        MCart cart=getCartById(cartId);
        if(cart==null||cart.getCartItems().size()==0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }
 }
