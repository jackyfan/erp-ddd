package com.ddd.rsa.notificationcontext.southbound.adapter.client;

import com.ddd.rsa.notificationcontext.southbound.message.CustomerResponse;

public interface CustomerClient {
    CustomerResponse customerOf(String customerId);
}
