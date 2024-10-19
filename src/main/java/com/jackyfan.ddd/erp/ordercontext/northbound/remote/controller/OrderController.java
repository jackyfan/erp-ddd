package com.ddd.rsa.ordercontext.northbound.remote.controller;

import com.ddd.rsa.ordercontext.northbound.local.appservice.OrderAppService;
import com.ddd.rsa.ordercontext.northbound.message.PlacingOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
    @Autowired
    private OrderAppService orderAppService;
    @PostMapping
    public void placeOrder(PlacingOrderRequest request) {
        orderAppService.placeOrder(request);
    }
}
