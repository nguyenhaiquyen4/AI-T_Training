package com.packt.webstore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {
    private Cart cart;

    @Before
    public void setup() {
        cart = new Cart("1");
    }

    @Test
    public void cart_grand_total_should_be_equal_to_total_product_units_price() {
//Arrange
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        Product ipad = new Product("P1235", "iPad", new BigDecimal(900));

        List<CartItem> cartItems = new ArrayList<>();

        CartItem cartItemIphone =  new CartItem("1");
        cartItemIphone.setProduct(iphone);
        cartItemIphone.setQuantity(2);

        cartItems.add(cartItemIphone);

        CartItem cartItemIpad =  new CartItem("2");
        cartItemIpad.setProduct(ipad);
        cartItemIpad.setQuantity(3);

        cartItems.add(cartItemIpad);
        cart.setCartItems(cartItems);
//Act
        BigDecimal grandTotal = cart.getGrandTotal();
//Assert
        Assert.assertEquals(new BigDecimal(2*500+3*900),
                grandTotal);
    }
}
