package com.ddd.rsa.ordercontext.southbound.message;

import com.ddd.rsa.ordercontext.domain.Order;

import java.io.Serializable;

public class LockingInventoryRequest implements Serializable {
    public static LockingInventoryRequest from(Order order) {
        return new LockingInventoryRequest();
    }
}
