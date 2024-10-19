package com.ddd.rsa.ordercontext.southbound.port.repository;

import com.ddd.rsa.ordercontext.domain.CustomerId;
import com.ddd.rsa.ordercontext.domain.Order;
import com.ddd.rsa.ordercontext.domain.OrderId;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface OrderRepository {
    // 查询方法的命名更加倾向于自然语言，不必体现find的技术含义
    Optional<Order> orderOf(OrderId orderId);
    // 以下两个方法在内部实现时，需要组装为通用接口的criteria
    Collection<Order> allOrdersOfCustomer(CustomerId customerId);
    Collection<Order> allInProgressOrdersOfCustomer(CustomerId customerId);
    void add(Order order);
    void addAll(Collection<Order> orders);
    // 业务上是更新(update)，而非替换(replace)
    void update(Order order);
    void updateAll(Collection<Order> orders);
    // 根据订单的需求，不提供删除方法
}
