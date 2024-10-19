package com.ddd.rsa.inventorycontext.southbound.port.repository;

import com.ddd.rsa.inventorycontext.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InventoryRepository {
    List<Product> productsOf(List<String> productIds);
}
