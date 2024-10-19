package com.ddd.rsa.ordercontext.domain;

import com.ddd.rsa.core.domain.UUIDIdentity;

public class CustomerId extends UUIDIdentity {
    public static CustomerId of(String customerIdValue) {
        return new CustomerId(customerIdValue);
    }

    private CustomerId(String customerIdValue){
        super();
    }
}
