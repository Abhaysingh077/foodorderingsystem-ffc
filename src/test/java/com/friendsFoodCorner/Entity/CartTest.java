package com.friendsFoodCorner.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CartTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Cart#Cart()}
     *   <li>{@link Cart#setId(int)}
     *   <li>{@link Cart#setImage(String)}
     *   <li>{@link Cart#setItem(String)}
     *   <li>{@link Cart#setName(String)}
     *   <li>{@link Cart#setOrdered_On(Date)}
     *   <li>{@link Cart#setPrice(double)}
     *   <li>{@link Cart#setQuantity(double)}
     *   <li>{@link Cart#setTotal(double)}
     *   <li>{@link Cart#toString()}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getImage()}
     *   <li>{@link Cart#getItem()}
     *   <li>{@link Cart#getName()}
     *   <li>{@link Cart#getOrdered_On()}
     *   <li>{@link Cart#getPrice()}
     *   <li>{@link Cart#getQuantity()}
     *   <li>{@link Cart#getTotal()}
     * </ul>
     */
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

    /**
     * Method under test: {@link Cart#Cart(int, String, String, Date, double, double, double, String)}
     */
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Cart actualCart = new Cart(1, "Item", "Image", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()),
                10.0d, 10.0d, 10.0d, "Name");

        assertEquals(1, actualCart.getId());
        assertEquals(10.0d, actualCart.getTotal());
        assertEquals(10.0d, actualCart.getQuantity());
        assertEquals(10.0d, actualCart.getPrice());
        Date expectedOrdered_On = actualCart.Ordered_On;
        assertSame(expectedOrdered_On, actualCart.getOrdered_On());
        assertEquals("Name", actualCart.getName());
        assertEquals("Item", actualCart.getItem());
        assertEquals("Image", actualCart.getImage());
    }
}

