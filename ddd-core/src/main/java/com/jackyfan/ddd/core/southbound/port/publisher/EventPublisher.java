package com.jackyfan.ddd.core.southbound.port.publisher;


import com.jackyfan.ddd.core.event.Event;

public interface EventPublisher<T extends Event> {
    void publish(T event);
}