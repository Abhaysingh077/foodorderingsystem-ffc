package com.FoodPostman;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
public class FoodControllerPost{
	@Autowired
	MenuService menuService;

	@GetMapping("/menu")
	public List<Menu> getAllItems() {
		return menuService.getAllItems();
	}

	@GetMapping("/men/{category}")
	public List<Menu> getAllItem_names(@PathVariable String category) {
		return menuService.findAllItem(category);
	}

	@GetMapping("/mnu/{item}")
	public Menu getAllItem_name(@PathVariable String item) {
		return menuService.findAllItems(item);
	}

	@GetMapping("/menus/{id}")
	public Menu getItem(@PathVariable int id) {
		return menuService.getItemById(id);
	}

	@DeleteMapping("/menu/{id}")
	public void deleteItem(@PathVariable("id") int id) {
		menuService.deleteItemById(id);
	}

	@PostMapping("/addmenu")
	public void addMenu(@RequestBody Menu menu) {
		menuService.save(menu);
	}

	@GetMapping("/cart")
	public List<Cart> getAllIt() {
		return menuService.getAllIt();
	}

	@GetMapping("/cart/{name}")
	public List<Cart> findAll(@PathVariable("name") String name) {
		return menuService.findAllIt(name);

	}

	@PostMapping("/addcart")
	public Menu addCart(@RequestBody Cart cart) {
		return menuService.findCart(cart);
	}
	@PutMapping("/cart")
	public Cart update(@RequestBody Cart cart ) {
		return menuService.updatecart(cart);
		
	}
	
	
}
