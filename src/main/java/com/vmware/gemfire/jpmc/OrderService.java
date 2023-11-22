package com.vmware.gemfire.jpmc;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Order putOrder(String id) {
    return orderRepository.save(new Order(id, "unsettled"));
  }

  public Order putOrder(Order order) {
    return orderRepository.save(order);
  }
}
