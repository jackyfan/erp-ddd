package com.ddd.rsa.ordercontext.southbound.adapter.repository;

import com.ddd.rsa.core.domain.Repository;
import com.ddd.rsa.ordercontext.domain.CustomerId;
import com.ddd.rsa.ordercontext.domain.Order;
import com.ddd.rsa.ordercontext.domain.OrderId;
import com.ddd.rsa.ordercontext.southbound.port.repository.OrderRepository;
import org.hibernate.Criteria;

import java.util.Collection;
import java.util.Optional;

public class OrderRepositoryAdapter implements OrderRepository {
    // 以委派形式复用通用的资源库接口
    private final Repository<Order, OrderId> repository;
    // 注入真正的资源库实现
    public OrderRepositoryAdapter(Repository<Order, OrderId> repository) {
        this.repository = repository;
    }
    public Optional<Order> orderOf(OrderId orderId) {
        return repository.findById(orderId);
    }
    @Override
    public Collection<Order> allOrdersOfCustomer(CustomerId customerId) {
        // 封装了组装查询条件的逻辑
        Criteria customerIdCriteria = new EquationCriteria("customerId", customerId);
        return repository.findAllMatching(customerIdCriteria);
    }
    @Override
    public Collection<Order> allInProgressOrdersOfCustomer(CustomerId customerId) {
        Criteria customerIdCriteria = new EquationCriteria("customerId", customerId);
        Criteria inProgressCriteria = new EquationCriteria("orderStatus",OrderStatus.
                InProgress);
        return repository.findAllMatching(customerIdCriteria.and(inProgressCriteria));
    }
    @Override
    public void add(Order order) {
        repository.save(order);
    }
    @Override
    public void addAll(Collection<Order> orders) {
        repository.saveAll(orders);
    }
    @Override
    public void update(Order order) {
        repository.save(order);
    }
    @Override
    public void updateAll(Collection<Order> orders) {
        repository.saveAll(orders);
    }
}
