package com.foo.service;

import java.util.Map;

import com.foo.model.Order;

public interface OrderCaluclation {
	
	void calculatePrice(Map<String, Order> o);

}
