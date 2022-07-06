package com.FoodPostman.controller;
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

@CrossOrigin(origins = "*")
@RestController
public class FoodControllerPost{
	@Autowired
	MenuService menuService;
	@Autowired
	UserRepo userRepo;
	
//===============menu================
	
	@GetMapping("/menu")
	public List<Menu> getAllItems() throws ItemNotFoundException {
List<Menu> items= menuService.getAllItems();
		if(items.isEmpty()){
			throw new ItemNotFoundException("Menu Is Empty");
		}else{
			return items;
		}
	}

	@GetMapping("/men/{category}")
	public List<Menu> getAllItem_names(@PathVariable String category) throws ItemNotFoundException {
		List<Menu> itemByCat= menuService.findAllItem(category);
		if(itemByCat.isEmpty()){
			throw new ItemNotFoundException("Category Doesn't Exist");
		}else{
			return itemByCat;
		}
	}

	@GetMapping("/mnu/{item}")
	public Menu getAllItem_name(@PathVariable String item) throws ItemNotFoundException {
		Menu itemByName = menuService.findAllItems(item);
		if(!itemByName.equals(null)){
			return itemByName;
		}else{

			throw new ItemNotFoundException("Food Items Doesn't Exist");
		}
	}

	@GetMapping("/menus/{id}")
	public Menu getItem(@PathVariable int id) {

		return menuService.getItemById(id);
	}
	@DeleteMapping("/menu/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		menuService.deleteItemById(id);
		return "Product Deleted";
	}
		

	@PostMapping("/addmenu")
	public void addMenu(@RequestBody Menu menu) {
		menuService.save(menu);
	}
//	========= Cart=============

	@GetMapping("/cart")
	public List<Cart> getAllIt() throws ItemNotFoundException {
		List<Cart> carts= menuService.getAllIt();
		if(carts.isEmpty()){
			throw new ItemNotFoundException("Cart Isd5 Empty");
		}else{
			return carts;
		}
	}

	@GetMapping("/cart/{name}")
	public List<Cart> findAll(@PathVariable("name") String name) throws ItemNotFoundException {
		List<Cart> cartByName= menuService.findAllIt(name);
		if(cartByName.isEmpty()){
			throw new ItemNotFoundException("Cart with this Name is not Exist");
		}else{
			return cartByName;
		}

	}

	@PostMapping("/addcart")
	public Menu addCart(@RequestBody Cart cart) {
		return menuService.findCart(cart);
	}
	@PutMapping("/cart")
	public Cart update(@RequestBody Cart cart ) {
		return menuService.updatecart(cart);
		
	}
	@DeleteMapping("/cart/{id}")
	public void delete(@PathVariable("id") int id) {
		menuService.deleteItem(id);
	}


//	=========users===============

	
	@GetMapping("/signup")
    public List<NewUser> getAllUsers() {
        return menuService.findAllUsers();
    }

    @PostMapping("/signup")
    public NewUser saveUsers(@RequestBody NewUser user) {
        return menuService.saveusers(user);
    }
	
    @DeleteMapping("/signup/{id}")
    public void deleteItems(@PathVariable("id")int id){
        try {
              userRepo.deleteById(id);
            
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            
        }
       
    }
}
