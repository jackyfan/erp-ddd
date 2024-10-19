package com.ddd.rsa.ordercontext.southbound.message;

import com.ddd.rsa.ordercontext.domain.Order;

import java.io.Serializable;
public class CheckingInventoryRequest implements Serializable {
    public static CheckingInventoryRequest from(Order order) {
        return new CheckingInventoryRequest();
    }
}
