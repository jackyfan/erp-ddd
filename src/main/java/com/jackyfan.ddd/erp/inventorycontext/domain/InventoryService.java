package com.ddd.rsa.inventorycontext.domain;

import com.ddd.rsa.inventorycontext.southbound.port.repository.InventoryRepository;
import com.ddd.rsa.ordercontext.southbound.message.InventoryReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryReview reviewInventory(List<PurchasedProduct> purchasedProducts) {
        List<String> productIds = purchasedProducts.stream().map(PurchasedProduct::productId).
                collect(Collectors.toList());
        List<Product> products = inventoryRepository.productsOf(productIds);

        List<Availability> availabilities = products.stream().map(p -> p.checkAvailability
                (purchasedProducts)).collect(Collectors.toList());
        return new InventoryReview(availabilities);
    }
}
