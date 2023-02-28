package com.main.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.order.model.Order;
import com.main.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/Order")
	public String postOrer(@RequestBody Order order) {
		return service.addOrder(order);
	}
	
	@GetMapping("/Order")
	public List<Order> getOrder(){
		return service.getOrders();
	}
	
	@GetMapping("/Order/{field}")
	public List<Order> getSorted(@PathVariable String field){
		return service.getOrderSorted(field);
	}
	
	@GetMapping("/Order/{offset}/{size}")
	public List<Order> getPaginated(@PathVariable int offset , @PathVariable int size){
		return service.getOrderPaginated(offset, size);
	}
	
	@GetMapping("/Order/{offset}/{size}/{field}")
	public List<Order> getPaginated(@PathVariable int offset , @PathVariable int size,@PathVariable String field){
		return service.getOrderPaginated(offset, size,field);
	}
	
	@PutMapping("/Order")
	public String putOrder(@RequestBody Order order) {
		return service.updateOrder(order);
	}
	
	@DeleteMapping("/Order/{id}")
	public String deleteOrder(@PathVariable int id) {
		return service.deleteOrder(id);
	}
}
