package com.FoodPostman.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.FoodPostman.controller.Admin;

class AdminTest {

    @Test
    void testConstructor() {
        Admin actualAdmin = new Admin();
        actualAdmin.setEmail("jane.doe@example.org");
        actualAdmin.setId(1);
        actualAdmin.setName("Name");
        actualAdmin.setPassword("iloveyou");
        String actualToStringResult = actualAdmin.toString();
        assertEquals("jane.doe@example.org", actualAdmin.getEmail());
        assertEquals(1, actualAdmin.getId());
        assertEquals("Name", actualAdmin.getName());
        assertEquals("iloveyou", actualAdmin.getPassword());
        assertEquals("Admin [id=1, name=Name, email=jane.doe@example.org, password=iloveyou]", actualToStringResult);
    }


    @Test
    void testConstructor2() {
        Admin actualAdmin = new Admin(1, "Name", "jane.doe@example.org", "iloveyou");
        actualAdmin.setEmail("jane.doe@example.org");
        actualAdmin.setId(1);
        actualAdmin.setName("Name");
        actualAdmin.setPassword("iloveyou");
        String actualToStringResult = actualAdmin.toString();
        assertEquals("jane.doe@example.org", actualAdmin.getEmail());
        assertEquals(1, actualAdmin.getId());
        assertEquals("Name", actualAdmin.getName());
        assertEquals("iloveyou", actualAdmin.getPassword());
        assertEquals("Admin [id=1, name=Name, email=jane.doe@example.org, password=iloveyou]", actualToStringResult);
    }


    @Test
    void testConstructor3() {
        Admin actualAdmin = new Admin();
        actualAdmin.setEmail("jane.doe@example.org");
        actualAdmin.setId(1);
        actualAdmin.setName("Name");
        actualAdmin.setPassword("iloveyou");
        String actualToStringResult = actualAdmin.toString();
        assertEquals("jane.doe@example.org", actualAdmin.getEmail());
        assertEquals(1, actualAdmin.getId());
        assertEquals("Name", actualAdmin.getName());
        assertEquals("iloveyou", actualAdmin.getPassword());
        assertEquals("Admin [id=1, name=Name, email=jane.doe@example.org, password=iloveyou]", actualToStringResult);
    }


    @Test
    void testConstructor4() {
        Admin actualAdmin = new Admin(1, "Name", "jane.doe@example.org", "iloveyou");
        actualAdmin.setEmail("jane.doe@example.org");
        actualAdmin.setId(1);
        actualAdmin.setName("Name");
        actualAdmin.setPassword("iloveyou");
        String actualToStringResult = actualAdmin.toString();
        assertEquals("jane.doe@example.org", actualAdmin.getEmail());
        assertEquals(1, actualAdmin.getId());
        assertEquals("Name", actualAdmin.getName());
        assertEquals("iloveyou", actualAdmin.getPassword());
        assertEquals("Admin [id=1, name=Name, email=jane.doe@example.org, password=iloveyou]", actualToStringResult);
    }
}

