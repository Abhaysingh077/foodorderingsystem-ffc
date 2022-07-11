package com.friendsFoodCorner.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MenuTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Menu#Menu()}
     *   <li>{@link Menu#setCategory(String)}
     *   <li>{@link Menu#setId(int)}
     *   <li>{@link Menu#setImage(String)}
     *   <li>{@link Menu#setItem(String)}
     *   <li>{@link Menu#setPrice(double)}
     *   <li>{@link Menu#toString()}
     *   <li>{@link Menu#getCategory()}
     *   <li>{@link Menu#getId()}
     *   <li>{@link Menu#getImage()}
     *   <li>{@link Menu#getItem()}
     *   <li>{@link Menu#getPrice()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Menu actualMenu = new Menu();
        actualMenu.setCategory("Category");
        actualMenu.setId(1);
        actualMenu.setImage("Image");
        actualMenu.setItem("Item");
        actualMenu.setPrice(10.0d);
        String actualToStringResult = actualMenu.toString();
        assertEquals("Category", actualMenu.getCategory());
        assertEquals(1, actualMenu.getId());
        assertEquals("Image", actualMenu.getImage());
        assertEquals("Item", actualMenu.getItem());
        assertEquals(10.0d, actualMenu.getPrice());
        assertEquals("Menu [id=1, item=Item, image=Image, category=Category, price=10.0]", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Menu#Menu(int, String, String, String, double)}
     *   <li>{@link Menu#setCategory(String)}
     *   <li>{@link Menu#setId(int)}
     *   <li>{@link Menu#setImage(String)}
     *   <li>{@link Menu#setItem(String)}
     *   <li>{@link Menu#setPrice(double)}
     *   <li>{@link Menu#toString()}
     *   <li>{@link Menu#getCategory()}
     *   <li>{@link Menu#getId()}
     *   <li>{@link Menu#getImage()}
     *   <li>{@link Menu#getItem()}
     *   <li>{@link Menu#getPrice()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Menu actualMenu = new Menu(1, "Item", "Image", "Category", 10.0d);
        actualMenu.setCategory("Category");
        actualMenu.setId(1);
        actualMenu.setImage("Image");
        actualMenu.setItem("Item");
        actualMenu.setPrice(10.0d);
        String actualToStringResult = actualMenu.toString();
        assertEquals("Category", actualMenu.getCategory());
        assertEquals(1, actualMenu.getId());
        assertEquals("Image", actualMenu.getImage());
        assertEquals("Item", actualMenu.getItem());
        assertEquals(10.0d, actualMenu.getPrice());
        assertEquals("Menu [id=1, item=Item, image=Image, category=Category, price=10.0]", actualToStringResult);
    }
}

