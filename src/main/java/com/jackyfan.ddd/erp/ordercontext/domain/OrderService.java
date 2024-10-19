package com.ddd.rsa.ordercontext.domain;

import com.ddd.rsa.ordercontext.southbound.message.InventoryReview;
import com.ddd.rsa.ordercontext.southbound.port.client.InventoryClient;
import com.ddd.rsa.ordercontext.southbound.port.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private InventoryClient inventoryClient;
    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(Order order) {
        if (!order.isInvalid()) {
           // throw new InvalidOrderException();
        }
        InventoryReview inventoryReview = inventoryClient.check(order);
        if (!inventoryReview.isAvailable()) {
            //throw new NotEnoughInventoryException();
        }
        orderRepository.add(order);
        //ShoppingCartService.removeItems(order.customerId(), order.purchasedProducts());
        inventoryClient.lock(order);
    }
}
