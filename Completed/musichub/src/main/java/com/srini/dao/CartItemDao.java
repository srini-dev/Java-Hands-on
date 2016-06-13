package com.srini.dao;

import com.srini.model.MCart;
import com.srini.model.MCartItem;

public interface CartItemDao {

	void addCartItem(MCartItem cartItem);

	void removeCartItem(MCartItem cartItem);

	void removeAllCartItems(MCart cart);

	MCartItem getCartItemByItemId(int itemId);

}
