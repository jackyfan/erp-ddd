package com.ddd.rsa.ordercontext.southbound.message;

import java.io.Serializable;

public class InventoryReviewResponse implements Serializable {
    public InventoryReview to() {
        return new InventoryReview();
    }
}
