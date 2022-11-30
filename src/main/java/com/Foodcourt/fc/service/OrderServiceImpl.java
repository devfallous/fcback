package com.Foodcourt.fc.service;

import com.Foodcourt.fc.Entity.Order;
import com.Foodcourt.fc.Repository.OrderRepository;
import com.Foodcourt.fc.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getPhNo(),orderDTO.getOrder());
        orderRepository.save(order);
    }
}
