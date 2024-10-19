package com.ddd.rsa.notificationcontext.northbound.remote.subscriber;

import com.alibaba.fastjson.JSON;
import com.ddd.rsa.notificationcontext.northbound.local.appservice.OrderPlacedEventHandler;
import com.ddd.rsa.ordercontext.southbound.message.OrderPlaced;
import org.springframework.beans.factory.annotation.Autowired;

public class EventSubscriber {
    @Autowired
    private OrderPlacedEventHandler eventHandler;

    //@KafkaListener(id = "order-placed", clientIdPrefix = "order", topics = {"topic.e-
    //commerce.order"}, containerFactory = " containerFactory")
    public void subscribeEvent(String eventData) {
        OrderPlaced orderPlaced = JSON.parseObject(eventData, OrderPlaced.class);
        eventHandler.handle(orderPlaced);
    }
}
