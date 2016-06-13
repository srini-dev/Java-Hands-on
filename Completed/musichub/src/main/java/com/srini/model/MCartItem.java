package com.srini.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class MCartItem implements Serializable{

    private static final long serialVersionUID = 14L;

    @Id
    @GeneratedValue
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private MCart cart;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private MItem item;

    private int quantity;
    private double totalPrice;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public MCart getCart() {
        return cart;
    }

    public void setCart(MCart cart) {
        this.cart = cart;
    }

    public MItem getItem() {
        return item;
    }

    public void setItem(MItem item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
