package com.foo.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.foo.model.Order;
import com.foo.service.OrderCaluclation;
import com.foo.util.CaluclatorUtils;

public class OrderCaluclationImpl implements OrderCaluclation {

	
	private static final Logger logger=LoggerFactory.getLogger(CaluclatorUtils.class);
	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void calculatePrice(Map<String, Order> o) {
		logger.info("Enetered into order caluclation ");

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			logger.info("*******" + entry.getKey() + "*******");

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = CaluclatorUtils.rounding(r.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on
					// imported items
				} else {
					tax = CaluclatorUtils.rounding(r.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = CaluclatorUtils.rounding(r.get(i).getItem().getPrice() + tax);

				// Print out the item's total price
				logger.info(r.get(i).getQuantity() +" " + r.get(i).getItem().getDescription() + ": " + totalprice);

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			logger.info("Sales Tax: " + CaluclatorUtils.rounding(totalTax));

			// Print out the total amount
			logger.info("Total: " + CaluclatorUtils.rounding(total));
			grandtotal += total;
		}

		logger.info("Sum of orders: " + CaluclatorUtils.rounding(grandtotal));
	}


}
