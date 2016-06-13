package com.srini.service;

import com.srini.model.MUserOrder;


public interface OrderService {

    void addOrder(MUserOrder order);

    double getOrderGrandTotal(int cartId);
}
