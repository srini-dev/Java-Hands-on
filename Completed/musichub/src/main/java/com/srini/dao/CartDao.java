package com.srini.dao;

import com.srini.model.MCart;

import java.io.IOException;

public interface CartDao {

	MCart getCartById(int cartId);

	MCart validate(int cartId) throws IOException;

	void update(MCart cart);
}
