package com.FoodPostman;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.FoodPostman.controller.Cart;
import com.FoodPostman.controller.FoodControllerPost;
import com.FoodPostman.controller.Menu;
import com.FoodPostman.controller.MenuService;
import com.FoodPostman.controller.NewUser;
import com.FoodPostman.controller.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FoodControllerPost.class})
@ExtendWith(SpringExtension.class)
class FoodControllerPostTest {
    @Autowired
    private FoodControllerPost foodControllerPost;

    @MockBean
    private MenuService menuService;

    @MockBean
    private UserRepo userRepo;

    @Test
    void testAddCart2() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findCart((Cart) any())).thenReturn(menu);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(cart);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addcart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }

    @Test
    void testAddCart3() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findCart((Cart) any())).thenReturn(menu);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(cart);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addcart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }


    @Test
    void testAddMenu2() throws Exception {
        doNothing().when(menuService).save((Menu) any());

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addmenu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testAddMenu3() throws Exception {
        doNothing().when(menuService).save((Menu) any());

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addmenu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testFindAll3() throws Exception {
        when(menuService.findAllIt((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "Name");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testFindAll4() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        when(menuService.findAllIt((String) any())).thenThrow(new IllegalArgumentException("?"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testFindAll5() throws Exception {
        when(menuService.findAllIt((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "Name");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testFindAll6() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        when(menuService.findAllIt((String) any())).thenThrow(new IllegalArgumentException("?"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllItem_name2() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findAllItems((String) any())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mnu/{item}", "Item");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }

    @Test
    void testGetAllItem_name3() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findAllItems((String) any())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mnu/{item}", "Item");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }

    @Test
    void testGetAllItem_names2() throws Exception {
        when(menuService.findAllItem((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/men/{category}", "Category");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllItem_names3() throws Exception {
        when(menuService.findAllItem((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/men/{category}", "Category");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllItems() throws Exception {
        when(menuService.getAllItems()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menu");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllItems2() throws Exception {
        when(menuService.getAllItems()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menu");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllItems3() throws Exception {
        when(menuService.getAllItems()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menu");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllIt() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllIt2() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
    @Test
    void testGetAllIt3() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testAddCart() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findCart((Cart) any())).thenReturn(menu);

        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(cart);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addcart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }


    @Test
    void testDelete() throws Exception {
        doNothing().when(menuService).deleteItem(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cart/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDelete2() throws Exception {
        doNothing().when(menuService).deleteItem(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cart/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDelete3() throws Exception {
        doNothing().when(menuService).deleteItem(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cart/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItem() throws Exception {
        doNothing().when(menuService).deleteItemById(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/menu/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItem2() throws Exception {
        doNothing().when(menuService).deleteItemById(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/menu/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItem3() throws Exception {
        doNothing().when(menuService).deleteItemById(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/menu/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItems() throws Exception {
        doNothing().when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItems2() throws Exception {
        doThrow(new IllegalArgumentException("?")).when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItems3() throws Exception {
        doNothing().when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void testDeleteItems4() throws Exception {
        doNothing().when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteItems5() throws Exception {
        doThrow(new IllegalArgumentException("?")).when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testDeleteItems6() throws Exception {
        doNothing().when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testDeleteItems7() throws Exception {
        doNothing().when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testDeleteItems8() throws Exception {
        doThrow(new IllegalArgumentException("?")).when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testDeleteItems9() throws Exception {
        doNothing().when(userRepo).deleteById((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/signup/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testAddMenu() throws Exception {
        doNothing().when(menuService).save((Menu) any());

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addmenu")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testFindAll() throws Exception {
        when(menuService.findAllIt((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "Name");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testFindAll2() throws Exception {
        when(menuService.getAllIt()).thenReturn(new ArrayList<>());
        when(menuService.findAllIt((String) any())).thenThrow(new IllegalArgumentException("?"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/{name}", "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllItem_name() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.findAllItems((String) any())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/mnu/{item}", "Item");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }


    @Test
    void testGetAllItem_names() throws Exception {
        when(menuService.findAllItem((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/men/{category}", "Category");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllUsers() throws Exception {
        when(menuService.findAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/signup");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllUsers2() throws Exception {
        when(menuService.findAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/signup");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetAllUsers3() throws Exception {
        when(menuService.findAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/signup");
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    @Test
    void testGetItem() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.getItemById(anyInt())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menus/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }


    @Test
    void testGetItem2() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.getItemById(anyInt())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menus/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }


    @Test
    void testGetItem3() throws Exception {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuService.getItemById(anyInt())).thenReturn(menu);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menus/{id}", 1);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"category\":\"Category\",\"price\":10.0}"));
    }


    @Test
    void testSaveUsers() throws Exception {
        NewUser newUser = new NewUser();
        newUser.setEmail("jane.doe@example.org");
        newUser.setId(1);
        newUser.setName("Name");
        newUser.setPassword("iloveyou");
        newUser.setUsername("janedoe");
        when(menuService.saveusers((NewUser) any())).thenReturn(newUser);

        NewUser newUser1 = new NewUser();
        newUser1.setEmail("jane.doe@example.org");
        newUser1.setId(1);
        newUser1.setName("Name");
        newUser1.setPassword("iloveyou");
        newUser1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(newUser1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\"}"));
    }


    @Test
    void testSaveUsers2() throws Exception {
        NewUser newUser = new NewUser();
        newUser.setEmail("jane.doe@example.org");
        newUser.setId(1);
        newUser.setName("Name");
        newUser.setPassword("iloveyou");
        newUser.setUsername("janedoe");
        when(menuService.saveusers((NewUser) any())).thenReturn(newUser);

        NewUser newUser1 = new NewUser();
        newUser1.setEmail("jane.doe@example.org");
        newUser1.setId(1);
        newUser1.setName("Name");
        newUser1.setPassword("iloveyou");
        newUser1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(newUser1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\"}"));
    }


    @Test
    void testSaveUsers3() throws Exception {
        NewUser newUser = new NewUser();
        newUser.setEmail("jane.doe@example.org");
        newUser.setId(1);
        newUser.setName("Name");
        newUser.setPassword("iloveyou");
        newUser.setUsername("janedoe");
        when(menuService.saveusers((NewUser) any())).thenReturn(newUser);

        NewUser newUser1 = new NewUser();
        newUser1.setEmail("jane.doe@example.org");
        newUser1.setId(1);
        newUser1.setName("Name");
        newUser1.setPassword("iloveyou");
        newUser1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(newUser1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"name\":\"Name\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\"}"));
    }


    @Test
    void testUpdate() throws Exception {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(menuService.updatecart((Cart) any())).thenReturn(cart);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(cart1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"quantity\":10.0,\"total\":10.0,\"price\":10.0,\"name\":\"Name\",\"ordered"
                                        + "_On\":0}"));
    }


    @Test
    void testUpdate2() throws Exception {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(menuService.updatecart((Cart) any())).thenReturn(cart);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(cart1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"quantity\":10.0,\"total\":10.0,\"price\":10.0,\"name\":\"Name\",\"ordered"
                                        + "_On\":0}"));
    }

    @Test
    void testUpdate3() throws Exception {
        Cart cart = new Cart();
        cart.setId(1);
        cart.setImage("Image");
        cart.setItem("Item");
        cart.setName("Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setOrdered_On(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setPrice(10.0d);
        cart.setQuantity(10.0d);
        cart.setTotal(10.0d);
        when(menuService.updatecart((Cart) any())).thenReturn(cart);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(10.0d);
        cart1.setTotal(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(cart1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(foodControllerPost)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"item\":\"Item\",\"image\":\"Image\",\"quantity\":10.0,\"total\":10.0,\"price\":10.0,\"name\":\"Name\",\"ordered"
                                        + "_On\":0}"));
    }
}

