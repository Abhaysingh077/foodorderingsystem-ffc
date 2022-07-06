package com.FoodPostman.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.FoodPostman.controller.Cart;

class CartTest {

    @Test
    void testConstructor() {
        Cart actualCart = new Cart();
        actualCart.setId(1);
        actualCart.setImage("Image");
        actualCart.setItem("Item");
        actualCart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualCart.setOrdered_On(fromResult);
        actualCart.setPrice(10.0d);
        actualCart.setQuantity(10.0d);
        actualCart.setTotal(10.0d);
        actualCart.toString();
        assertEquals(1, actualCart.getId());
        assertEquals("Image", actualCart.getImage());
        assertEquals("Item", actualCart.getItem());
        assertEquals("Name", actualCart.getName());
        assertSame(fromResult, actualCart.getOrdered_On());
        assertEquals(10.0d, actualCart.getPrice());
        assertEquals(10.0d, actualCart.getQuantity());
        assertEquals(10.0d, actualCart.getTotal());
    }


    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        Cart actualCart = new Cart(1, "Item", "Image", fromResult, 10.0d, 10.0d, 10.0d, "Name");

        assertEquals(1, actualCart.getId());
        assertEquals(10.0d, actualCart.getTotal());
        assertEquals(10.0d, actualCart.getQuantity());
        assertEquals(10.0d, actualCart.getPrice());
        assertSame(fromResult, actualCart.getOrdered_On());
        assertEquals("Name", actualCart.getName());
        assertEquals("Item", actualCart.getItem());
        assertEquals("Image", actualCart.getImage());
    }
}

