package com.FoodPostman.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewUserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link NewUser#NewUser()}
     *   <li>{@link NewUser#setEmail(String)}
     *   <li>{@link NewUser#setId(int)}
     *   <li>{@link NewUser#setName(String)}
     *   <li>{@link NewUser#setPassword(String)}
     *   <li>{@link NewUser#setUsername(String)}
     *   <li>{@link NewUser#toString()}
     *   <li>{@link NewUser#getEmail()}
     *   <li>{@link NewUser#getId()}
     *   <li>{@link NewUser#getName()}
     *   <li>{@link NewUser#getPassword()}
     *   <li>{@link NewUser#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        NewUser actualNewUser = new NewUser();
        actualNewUser.setEmail("jane.doe@example.org");
        actualNewUser.setId(1);
        actualNewUser.setName("Name");
        actualNewUser.setPassword("iloveyou");
        actualNewUser.setUsername("janedoe");
        String actualToStringResult = actualNewUser.toString();
        assertEquals("jane.doe@example.org", actualNewUser.getEmail());
        assertEquals(1, actualNewUser.getId());
        assertEquals("Name", actualNewUser.getName());
        assertEquals("iloveyou", actualNewUser.getPassword());
        assertEquals("janedoe", actualNewUser.getUsername());
        assertEquals("User [id=1, name=Name, username=janedoe, email=jane.doe@example.org, password=iloveyou]",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link NewUser#NewUser(int, String, String, String, String)}
     *   <li>{@link NewUser#setEmail(String)}
     *   <li>{@link NewUser#setId(int)}
     *   <li>{@link NewUser#setName(String)}
     *   <li>{@link NewUser#setPassword(String)}
     *   <li>{@link NewUser#setUsername(String)}
     *   <li>{@link NewUser#toString()}
     *   <li>{@link NewUser#getEmail()}
     *   <li>{@link NewUser#getId()}
     *   <li>{@link NewUser#getName()}
     *   <li>{@link NewUser#getPassword()}
     *   <li>{@link NewUser#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        NewUser actualNewUser = new NewUser(1, "Name", "janedoe", "jane.doe@example.org", "iloveyou");
        actualNewUser.setEmail("jane.doe@example.org");
        actualNewUser.setId(1);
        actualNewUser.setName("Name");
        actualNewUser.setPassword("iloveyou");
        actualNewUser.setUsername("janedoe");
        String actualToStringResult = actualNewUser.toString();
        assertEquals("jane.doe@example.org", actualNewUser.getEmail());
        assertEquals(1, actualNewUser.getId());
        assertEquals("Name", actualNewUser.getName());
        assertEquals("iloveyou", actualNewUser.getPassword());
        assertEquals("janedoe", actualNewUser.getUsername());
        assertEquals("User [id=1, name=Name, username=janedoe, email=jane.doe@example.org, password=iloveyou]",
                actualToStringResult);
    }
}

