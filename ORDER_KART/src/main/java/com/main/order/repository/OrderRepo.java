package com.main.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.order.model.Order;

public interface OrderRepo extends JpaRepository<Order,Integer>{

}
