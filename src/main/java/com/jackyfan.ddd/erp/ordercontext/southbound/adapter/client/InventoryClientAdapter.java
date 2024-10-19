package com.ddd.rsa.ordercontext.southbound.adapter.client;

import com.ddd.rsa.ordercontext.domain.Order;
import com.ddd.rsa.ordercontext.southbound.message.CheckingInventoryRequest;
import com.ddd.rsa.ordercontext.southbound.message.InventoryReview;
import com.ddd.rsa.ordercontext.southbound.message.InventoryReviewResponse;
import com.ddd.rsa.ordercontext.southbound.message.LockingInventoryRequest;
import com.ddd.rsa.ordercontext.southbound.port.client.InventoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClientAdapter implements InventoryClient {
    private static final String INVENTORIES_RESOURCE_URL = "http://inventory-service/inventories";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public InventoryReview check(Order order) {
        CheckingInventoryRequest request = CheckingInventoryRequest.from(order);
        InventoryReviewResponse reviewResponse = restTemplate.postForObject(INVENTORIES_RESOURCE_URL, request,
                InventoryReviewResponse.class);
        return reviewResponse.to();
    }

    @Override
    public void lock(Order order) {
        LockingInventoryRequest inventoryRequest = LockingInventoryRequest.from(order);
        restTemplate.put(INVENTORIES_RESOURCE_URL, inventoryRequest);
    }
}
