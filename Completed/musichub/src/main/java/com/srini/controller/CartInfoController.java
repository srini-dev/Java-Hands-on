package com.srini.controller;

import com.srini.model.*;

import com.srini.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 *Only for User Role
 *This controller is used to handle rest service calls.
 *All functionality related to user cart is written in this controller.
*/
@Controller
@RequestMapping("/usercart/cart")
public class CartInfoController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UsersDetailService usersDetailService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("/refreshCart/{cartId}")
    public @ResponseBody
    MCart getCartById (@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }
    /*
     * addItem method is used to add a item in user cart.
     */

    @RequestMapping(value = "/addItem/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value ="itemId") int itemId, @AuthenticationPrincipal User activeUser) {

    	MUsersDetail usersDetail = usersDetailService.getUserByUsername(activeUser.getUsername());
        MCart cart = usersDetail.getCart();
        MItem item = itemService.getItemById(itemId);
        List<MCartItem> cartItems = cart.getCartItems();

        for (int i=0; i<cartItems.size(); i++) {
            if(item.getItemId()==cartItems.get(i).getItem().getItemId()){
                MCartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(item.getItemPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        MCartItem cartItem = new MCartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(item.getItemPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }
    /*
     * removeItem method is used to remove a item from user cart.
     */
    @RequestMapping(value = "/removeItem/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable(value = "itemId") int itemId) {
        MCartItem cartItem = cartItemService.getCartItemByItemId(itemId);
        System.out.println("PPPPPPPPPPPPPPPPPP........1");
        cartItemService.removeCartItem(cartItem);
        System.out.println("PPPPPPPPPPPPPPPPPP........2");

    }
    /*
     * clearCartItems method is used to remove all items from user cart.
     */
    @RequestMapping(value = "/clearCartItems/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCartItems(@PathVariable(value = "cartId") int cartId) {
        MCart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }
    /*
     * ExceptionHandler for client errors.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}
    /*
     * ExceptionHandler for server errors.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}
}
