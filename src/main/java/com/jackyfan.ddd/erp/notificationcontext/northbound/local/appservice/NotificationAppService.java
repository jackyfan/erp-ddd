package com.ddd.rsa.notificationcontext.northbound.local.appservice;

import com.ddd.rsa.notificationcontext.domain.NotificationService;
import com.ddd.rsa.ordercontext.southbound.message.OrderPlaced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationAppService implements OrderPlacedEventHandler{
    @Autowired
    private NotificationService notificationService;
    public void handle(OrderPlaced orderPlaced) {
        notificationService.notify(orderPlaced.to());
    }
}
