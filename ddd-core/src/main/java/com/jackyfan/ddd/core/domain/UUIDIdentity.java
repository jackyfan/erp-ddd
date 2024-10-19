package com.jackyfan.ddd.core.domain;


import java.io.Serial;
import java.util.UUID;

public class UUIDIdentity implements RandomIdentity<String> {
    @Serial
    private static final long serialVersionUID = 1L;
    private String value;

    public UUIDIdentity() {
        this.value = next();
    }

    @Override
    public String next() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String value() {
        return value;
    }
}

