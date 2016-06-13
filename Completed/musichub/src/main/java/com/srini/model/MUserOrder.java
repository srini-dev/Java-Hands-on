package com.srini.model;

import javax.persistence.*;
import java.io.Serializable;



@Entity
public class MUserOrder implements Serializable{

    private static final long serialVersionUID = 16L;

    @Id
    @GeneratedValue
    private int userOrderId;
	@OneToOne
    @JoinColumn(name = "cartId")
    private MCart cart;

    @OneToOne
    @JoinColumn(name = "userId")
    private MUsersDetail usersDetail;

	@OneToOne
    @JoinColumn(name = "billingAddressId")
    private MBillingAdd billingAddress;

    @OneToOne
    @JoinColumn(name="shippingAddressId")
    private MShippingAdd shippingAddress;

    public int getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}

    public MCart getCart() {
        return cart;
    }

    public void setCart(MCart cart) {
        this.cart = cart;
    }


    public MBillingAdd getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(MBillingAdd billingAddress) {
        this.billingAddress = billingAddress;
    }

    public MShippingAdd getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(MShippingAdd shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public MUsersDetail getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(MUsersDetail usersDetail) {
		this.usersDetail = usersDetail;
	}
}
