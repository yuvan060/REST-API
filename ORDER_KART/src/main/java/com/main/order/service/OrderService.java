package com.main.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.main.order.model.Order;
import com.main.order.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo repository;
	
	public String addOrder(Order order) {
		System.out.print(order);
		repository.save(order);
		return "Order Booked";
	}
	
	public List<Order> getOrders(){
		return repository.findAll();
	}
	
	public List<Order> getOrderSorted(String field){
		return repository.findAll(Sort.by(field));
	}
	
	public List<Order> getOrderPaginated(int offset,int size){
		return repository.findAll(PageRequest.of(offset, size)).getContent();
	}
	
	public List<Order> getOrderPaginated(int offset,int size,String field){
		return repository.findAll(PageRequest.of(offset, size,Sort.by(field))).getContent();
	}
	
	public String updateOrder(Order order) {
		repository.save(order);
		return "Order Updated ";
	}
	
	public String  deleteOrder(int id) {
		repository.deleteById(id);
		return "Order Successfully Deleted";
	}
}
