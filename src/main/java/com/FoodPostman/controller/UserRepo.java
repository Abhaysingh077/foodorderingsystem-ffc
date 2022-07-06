package com.FoodPostman.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<NewUser, Integer> {

	NewUser findByName(String name);

}
