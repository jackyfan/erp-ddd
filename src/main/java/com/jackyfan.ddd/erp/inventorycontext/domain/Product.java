package com.ddd.rsa.inventorycontext.domain;

import java.util.List;

public class Product {
    private String productId;

    public Availability checkAvailability(List<PurchasedProduct> purchasedProducts) {
        return new Availability();
    }
}
