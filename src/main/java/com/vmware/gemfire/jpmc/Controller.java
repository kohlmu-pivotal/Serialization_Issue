package com.vmware.gemfire.jpmc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private OrderService orderService;

  public Controller(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping(path = "/order")
  public Order publishingOrder(@RequestBody Order order) {
    return orderService.putOrder(order);
  }
}
