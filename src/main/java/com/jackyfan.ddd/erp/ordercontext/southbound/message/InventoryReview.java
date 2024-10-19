package com.ddd.rsa.ordercontext.southbound.message;

import com.ddd.rsa.inventorycontext.domain.Availability;

import java.util.List;

public class InventoryReview {
    public InventoryReview(List<Availability> availabilities ){
    }
    public boolean isAvailable() {
        return Boolean.TRUE;
    }
}
