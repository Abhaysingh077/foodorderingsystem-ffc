package com.FoodPostman.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ItemNotFoundExceptionTest {
    /**
     * Method under test: {@link ItemNotFoundException#ItemNotFoundException(String)}
     */
    @Test
    void testConstructor() {
        ItemNotFoundException actualItemNotFoundException = new ItemNotFoundException("Msg");
        assertNull(actualItemNotFoundException.getCause());
        assertEquals(0, actualItemNotFoundException.getSuppressed().length);
        assertEquals("Msg", actualItemNotFoundException.getMessage());
        assertEquals("Msg", actualItemNotFoundException.getLocalizedMessage());
    }
}

