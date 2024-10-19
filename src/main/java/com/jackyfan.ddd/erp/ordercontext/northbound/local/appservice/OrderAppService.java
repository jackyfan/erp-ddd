package com.ddd.rsa.ordercontext.northbound.local.appservice;

import com.ddd.rsa.common.exception.ApplicationException;
import com.ddd.rsa.common.exception.DomainException;
import com.ddd.rsa.ordercontext.domain.Order;
import com.ddd.rsa.ordercontext.domain.OrderService;
import com.ddd.rsa.ordercontext.northbound.message.PlacingOrderRequest;
import com.ddd.rsa.ordercontext.southbound.message.OrderPlaced;
import com.ddd.rsa.ordercontext.southbound.port.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderAppService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private EventPublisher eventPublisher;
    //private static final Logger logger = LoggerFactory.getLogger(OrderAppService.class);
    //@Transactional(rollbackFor = ApplicationException.class)
    public void placeOrder(PlacingOrderRequest request) {
        try {
            Order order = request.to();
            orderService.placeOrder(order);
            OrderPlaced orderPlaced = OrderPlaced.from(order);
            eventPublisher.publish(orderPlaced);
        } catch (DomainException ex) {
            //logger.warn(ex.getMessage());
            throw new ApplicationException(ex.getMessage(), ex);
        }
    }
}
