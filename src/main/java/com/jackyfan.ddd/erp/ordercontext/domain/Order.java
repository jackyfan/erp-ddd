package com.ddd.rsa.ordercontext.domain;

import com.ddd.rsa.core.domain.AggregateRoot;

public class Order implements AggregateRoot {
    private String customerId;
    public boolean isInvalid(){
        return Boolean.TRUE;
    }

    public String customerId() {
        return customerId;
    }
}
