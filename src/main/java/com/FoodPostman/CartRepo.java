package com.FoodPostman;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CartRepo extends JpaRepository<Cart, Integer>, CrudRepository<Cart, Integer> {
	List<Cart> findByName(String name);

	Cart findByItem(String item);

	static List<Cart> findAllByUserIdOrderByCreatedDateDesc(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}
}