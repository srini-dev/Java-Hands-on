package com.srini.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@Entity
public class MCart implements Serializable {

    private static final long serialVersionUID = 13L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MCartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private MUsersDetail usersDetail;

   

	private double grandTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<MCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<MCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    public MUsersDetail getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(MUsersDetail usersDetail) {
		this.usersDetail = usersDetail;
	}
}
