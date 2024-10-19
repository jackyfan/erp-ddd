package com.ddd.rsa.ordercontext.southbound.port.publisher;

import com.ddd.rsa.ordercontext.southbound.message.OrderPlaced;

public interface EventPublisher {
    public void publish(OrderPlaced orderPlaced);
}
