package com.ddd.rsa.ordercontext.northbound.message;

import com.ddd.rsa.ordercontext.domain.Order;

import java.io.Serializable;

public class PlacingOrderRequest implements Serializable {
    public Order to() {
        return new Order();
    }
}
