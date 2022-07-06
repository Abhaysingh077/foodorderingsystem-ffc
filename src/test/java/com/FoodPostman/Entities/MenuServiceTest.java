package com.FoodPostman.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.FoodPostman.controller.AdminRepo;
import com.FoodPostman.controller.Cart;
import com.FoodPostman.controller.CartRepo;
import com.FoodPostman.controller.Menu;
import com.FoodPostman.controller.MenuRepo;
import com.FoodPostman.controller.MenuService;
import com.FoodPostman.controller.NewUser;
import com.FoodPostman.controller.UserRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MenuService.class})
@ExtendWith(SpringExtension.class)
class MenuServiceTest {
    @MockBean
    private AdminRepo adminRepo;

    @MockBean
    private CartRepo cartRepo;

    @MockBean
    private MenuRepo menuRepo;

    @Autowired
    private MenuService menuService;

    @MockBean
    private UserRepo userRepo;


    @Test
    void testGetItemById() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        Optional<Menu> ofResult = Optional.of(menu);
        when(menuRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(menu, menuService.getItemById(1));
        verify(menuRepo).findById((Integer) any());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testGetItemById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.FoodPostman.Entities.MenuService.getItemById(MenuService.java:29)
        //   In order to prevent getItemById(int)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getItemById(int).
        //   See https://diff.blue/R013 to resolve this issue.

        when(menuRepo.findById((Integer) any())).thenReturn(Optional.empty());
        menuService.getItemById(1);
    }


    @Test
    void testGetItemById3() {
        when(menuRepo.findById((Integer) any())).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.getItemById(1));
        verify(menuRepo).findById((Integer) any());
    }

    @Test
    void testGetAllItems() {
        when(menuRepo.findAll()).thenReturn(new ArrayList<>());
        assertTrue(menuService.getAllItems().isEmpty());
        verify(menuRepo).findAll();
    }

    @Test
    void testGetAllItems2() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        when(menuRepo.findAll()).thenReturn(menuList);
        assertEquals(1, menuService.getAllItems().size());
        verify(menuRepo).findAll();
    }

    @Test
    void testGetAllItems3() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        Menu menu1 = new Menu();
        menu1.setCategory("Category");
        menu1.setId(1);
        menu1.setImage("Image");
        menu1.setItem("Item");
        menu1.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu1);
        menuList.add(menu);
        when(menuRepo.findAll()).thenReturn(menuList);
        assertEquals(2, menuService.getAllItems().size());
        verify(menuRepo).findAll();
    }

    @Test
    void testGetAllItems4() {
        when(menuRepo.findAll()).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.getAllItems());
        verify(menuRepo).findAll();
    }

    @Test
    void testSave(){
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.save((Menu) any())).thenReturn(menu);

        Menu menu1 = new Menu();
        menu1.setCategory("Category");
        menu1.setId(1);
        menu1.setImage("Image");
        menu1.setItem("Item");
        menu1.setPrice(10.0d);
        menuService.save(menu1);
        verify(menuRepo).save((Menu) any());
        assertEquals("Category", menu1.getCategory());
        assertEquals(10.0d, menu1.getPrice());
        assertEquals("Item", menu1.getItem());
        assertEquals("Image", menu1.getImage());
        assertEquals(1, menu1.getId());
        assertTrue(menuService.findAllUsers().isEmpty());
        List<Menu> allItems = menuService.getAllItems();
        assertTrue(allItems.isEmpty());
        assertEquals(allItems, menuService.getAllIt());
    }

    @Test
    void testSave2() {
        when(menuRepo.save((Menu) any())).thenThrow(new ArithmeticException("foo"));

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        assertThrows(ArithmeticException.class, () -> menuService.save(menu));
        verify(menuRepo).save((Menu) any());
    }

    @Test
    void testDeleteItemById() {
        doNothing().when(menuRepo).deleteById((Integer) any());
        menuService.deleteItemById(1);
        verify(menuRepo).deleteById((Integer) any());
        assertTrue(menuService.findAllUsers().isEmpty());
        List<Menu> allItems = menuService.getAllItems();
        assertTrue(allItems.isEmpty());
        assertEquals(allItems, menuService.getAllIt());
    }


    @Test
    void testDeleteItemById2() {
        doThrow(new ArithmeticException("foo")).when(menuRepo).deleteById((Integer) any());
        assertThrows(ArithmeticException.class, () -> menuService.deleteItemById(1));
        verify(menuRepo).deleteById((Integer) any());
    }


    @Test
    void testFindAllItem() {
        when(menuRepo.findByCategory((String) any())).thenReturn(new ArrayList<>());
        assertTrue(menuService.findAllItem("Category").isEmpty());
        verify(menuRepo).findByCategory((String) any());
    }


    @Test
    void testFindAllItem2() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu);
        when(menuRepo.findByCategory((String) any())).thenReturn(menuList);
        assertEquals(1, menuService.findAllItem("Category").size());
        verify(menuRepo).findByCategory((String) any());
    }


    @Test
    void testFindAllItem3() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);

        Menu menu1 = new Menu();
        menu1.setCategory("Category");
        menu1.setId(1);
        menu1.setImage("Image");
        menu1.setItem("Item");
        menu1.setPrice(10.0d);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(menu1);
        menuList.add(menu);
        when(menuRepo.findByCategory((String) any())).thenReturn(menuList);
        assertEquals(2, menuService.findAllItem("Category").size());
        verify(menuRepo).findByCategory((String) any());
    }


    @Test
    void testFindAllItem4() {
        when(menuRepo.findByCategory((String) any())).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.findAllItem("Category"));
        verify(menuRepo).findByCategory((String) any());
    }

    @Test
    void testFindAllItems() {
        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);
        assertSame(menu, menuService.findAllItems("Item"));
        verify(menuRepo).findByItem((String) any());
    }


    @Test
    void testFindAllItems2() {
        when(menuRepo.findByItem((String) any())).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.findAllItems("Item"));
        verify(menuRepo).findByItem((String) any());
    }

    @Test
    void testGetAllIt() {
        when(cartRepo.findAll()).thenReturn(new ArrayList<>());
        assertTrue(menuService.getAllIt().isEmpty());
        verify(cartRepo).findAll();
    }


    @Test
    void testGetAllIt2() {
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

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepo.findAll()).thenReturn(cartList);
        assertEquals(1, menuService.getAllIt().size());
        verify(cartRepo).findAll();
    }


    @Test
    void testGetAllIt3() {
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

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart);
        when(cartRepo.findAll()).thenReturn(cartList);
        assertEquals(2, menuService.getAllIt().size());
        verify(cartRepo).findAll();
    }

    @Test
    void testGetAllIt4() {
        when(cartRepo.findAll()).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.getAllIt());
        verify(cartRepo).findAll();
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt() {
        when(cartRepo.findByName((String) any())).thenReturn(new ArrayList<>());
        assertTrue(menuService.findAllIt("Name").isEmpty());
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt2() {
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

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepo.findByName((String) any())).thenReturn(cartList);
        assertEquals(1, menuService.findAllIt("Name").size());
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt3() {
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

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart);
        when(cartRepo.findByName((String) any())).thenReturn(cartList);
        assertEquals(2, menuService.findAllIt("Name").size());
        verify(cartRepo).findByName((String) any());
    }

    /**
     * Method under test: {@link MenuService#findAllIt(String)}
     */
    @Test
    void testFindAllIt4() {
        when(cartRepo.findByName((String) any())).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.findAllIt("Name"));
        verify(cartRepo).findByName((String) any());
    }
    @Test
    void testFindCart() {
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
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

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
        assertSame(menu, menuService.findCart(cart1));
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
        assertEquals(100.0d, cart1.getTotal());
        assertEquals(10.0d, cart1.getQuantity());
        assertEquals(10.0d, cart1.getPrice());
        assertEquals("Name", cart1.getName());
        assertEquals("Item", cart1.getItem());
        assertEquals("Image", cart1.getImage());
    }
    @Test
    void testFindCart2() {
        when(cartRepo.save((Cart) any())).thenThrow(new ArithmeticException("foo"));

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

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
        assertSame(menu, menuService.findCart(cart));
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
        assertEquals(100.0d, cart.getTotal());
        assertEquals(10.0d, cart.getQuantity());
        assertEquals(10.0d, cart.getPrice());
        assertEquals("Name", cart.getName());
        assertEquals("Item", cart.getItem());
        assertEquals("Image", cart.getImage());
    }

    @Test
    void testFindCart3() {
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
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(0.5d);
        cart1.setTotal(10.0d);
        assertSame(menu, menuService.findCart(cart1));
        verify(menuRepo).findByItem((String) any());
    }
    @Test
    void testUpdatecart() {
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
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

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
        Cart actualUpdatecartResult = menuService.updatecart(cart1);
        assertSame(cart1, actualUpdatecartResult);
        assertEquals(1, actualUpdatecartResult.getId());
        assertEquals(100.0d, actualUpdatecartResult.getTotal());
        assertEquals(10.0d, actualUpdatecartResult.getPrice());
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
    }

    @Test
    void testUpdatecart2() {
        when(cartRepo.save((Cart) any())).thenThrow(new ArithmeticException("foo"));

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

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
        Cart actualUpdatecartResult = menuService.updatecart(cart);
        assertSame(cart, actualUpdatecartResult);
        assertEquals(1, actualUpdatecartResult.getId());
        assertEquals(100.0d, actualUpdatecartResult.getTotal());
        assertEquals(10.0d, actualUpdatecartResult.getPrice());
        verify(cartRepo).save((Cart) any());
        verify(menuRepo).findByItem((String) any());
    }

    @Test
    void testUpdatecart3() {
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
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Menu menu = new Menu();
        menu.setCategory("Category");
        menu.setId(1);
        menu.setImage("Image");
        menu.setItem("Item");
        menu.setPrice(10.0d);
        when(menuRepo.findByItem((String) any())).thenReturn(menu);

        Cart cart1 = new Cart();
        cart1.setId(1);
        cart1.setImage("Image");
        cart1.setItem("Item");
        cart1.setName("Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart1.setOrdered_On(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        cart1.setPrice(10.0d);
        cart1.setQuantity(0.5d);
        cart1.setTotal(10.0d);
        assertSame(cart1, menuService.updatecart(cart1));
    }


    @Test
    void testFindAllUsers() {
        ArrayList<NewUser> newUserList = new ArrayList<>();
        when(userRepo.findAll()).thenReturn(newUserList);
        List<NewUser> actualFindAllUsersResult = menuService.findAllUsers();
        assertSame(newUserList, actualFindAllUsersResult);
        assertTrue(actualFindAllUsersResult.isEmpty());
        verify(userRepo).findAll();
    }


    @Test
    void testFindAllUsers2() {
        when(userRepo.findAll()).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.findAllUsers());
        verify(userRepo).findAll();
    }

    @Test
    void testSaveusers() {
        NewUser newUser = new NewUser();
        newUser.setEmail("jane.doe@example.org");
        newUser.setId(1);
        newUser.setName("Name");
        newUser.setPassword("iloveyou");
        newUser.setUsername("janedoe");
        when(userRepo.save((NewUser) any())).thenReturn(newUser);

        NewUser newUser1 = new NewUser();
        newUser1.setEmail("jane.doe@example.org");
        newUser1.setId(1);
        newUser1.setName("Name");
        newUser1.setPassword("iloveyou");
        newUser1.setUsername("janedoe");
        assertSame(newUser, menuService.saveusers(newUser1));
        verify(userRepo).save((NewUser) any());
    }

    @Test
    void testSaveusers2() {
        when(userRepo.save((NewUser) any())).thenThrow(new ArithmeticException("foo"));

        NewUser newUser = new NewUser();
        newUser.setEmail("jane.doe@example.org");
        newUser.setId(1);
        newUser.setName("Name");
        newUser.setPassword("iloveyou");
        newUser.setUsername("janedoe");
        assertThrows(ArithmeticException.class, () -> menuService.saveusers(newUser));
        verify(userRepo).save((NewUser) any());
    }


    @Test
    void testDeleteItem() {
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
        when(cartRepo.deleteById(anyInt())).thenReturn(cart);
        menuService.deleteItem(1);
        verify(cartRepo).deleteById(anyInt());
        assertTrue(menuService.findAllUsers().isEmpty());
        List<Menu> allItems = menuService.getAllItems();
        assertTrue(allItems.isEmpty());
        assertEquals(allItems, menuService.getAllIt());
    }


    @Test
    void testDeleteItem2() {
        when(cartRepo.deleteById(anyInt())).thenThrow(new ArithmeticException("foo"));
        assertThrows(ArithmeticException.class, () -> menuService.deleteItem(1));
        verify(cartRepo).deleteById(anyInt());
    }
}

