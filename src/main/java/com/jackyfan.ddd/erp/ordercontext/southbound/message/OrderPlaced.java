package com.ddd.rsa.ordercontext.southbound.message;

import com.ddd.rsa.notificationcontext.domain.Notification;
import com.ddd.rsa.ordercontext.domain.Order;

public class OrderPlaced {
    public static OrderPlaced from(Order order) {
        return new OrderPlaced();
    }

    public Notification to() {
        return new Notification();
    }

}
