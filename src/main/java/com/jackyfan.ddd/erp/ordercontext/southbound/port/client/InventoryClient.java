package com.ddd.rsa.ordercontext.southbound.port.client;

import com.ddd.rsa.ordercontext.domain.Order;
import com.ddd.rsa.ordercontext.southbound.message.InventoryReview;

public interface InventoryClient {
    InventoryReview check(Order order);
    void lock(Order order);
}
