package com.FoodPostman.controller;

public class ItemNotFoundException extends IllegalArgumentException{
	ItemNotFoundException(String msg){
		super(msg);
	}
	
}
