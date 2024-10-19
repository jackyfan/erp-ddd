package com.ddd.rsa.notificationcontext.northbound.local.appservice;

import com.ddd.rsa.ordercontext.southbound.message.OrderPlaced;

public interface OrderPlacedEventHandler {
    void handle(OrderPlaced event);
}
