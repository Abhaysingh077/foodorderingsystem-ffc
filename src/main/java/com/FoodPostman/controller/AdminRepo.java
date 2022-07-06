package com.FoodPostman.controller;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepo extends JpaRepository<Admin, String> {




	public List<Admin> findByEmailAndPassword(String email, String password);
}

