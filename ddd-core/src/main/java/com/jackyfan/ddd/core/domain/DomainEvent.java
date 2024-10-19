package com.ddd.rsa.core.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public abstract class DomainEvent {
    protected final String eventId;
    protected final String occurredOn;
    public DomainEvent() {
        eventId = UUID.randomUUID().toString();
        occurredOn = new Timestamp(new Date().getTime()).toString();
    }
}