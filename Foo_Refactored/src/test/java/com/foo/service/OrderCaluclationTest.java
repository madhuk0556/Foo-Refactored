package com.foo.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.foo.model.Item;
import com.foo.model.Order;
import com.foo.model.OrderLine;
import com.foo.service.impl.OrderCaluclationImpl;

public class OrderCaluclationTest {
	
	Map<String, Order> orders = new HashMap<String, Order>();
	
	@Before
	public void loadTestData() throws Exception{

		Order order = new Order();

		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		orders.put("Order 1", order);

		// Reuse cart for an other order
		order= new Order();

		order.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		order.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		orders.put("Order 2", order);

		// Reuse cart for an other order
		order= new Order();

		order.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		order.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		order.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		order.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		orders.put("Order 3", order);
	}
	
	@Test
	public void testOrderCaluclation(){
		
		OrderCaluclation caluclation=new OrderCaluclationImpl();
		caluclation.calculatePrice(orders);
		
	}
	

}
