package com.FoodPostman.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.FoodPostman.controller.Menu;

class MenuTest {

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

