package com.jackyfan.ddd.core.domain;

import ch.qos.logback.core.testUtil.RandomUtil;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class EmployeeId implements Identity<String>, Serializable {
    private String value;
    private static Random random;
    static {
        random = new Random();
    }
    // 必须提供默认的构造函数
    public EmployeeId() {
    }
    private EmployeeId(String value) {
        this.value = value;
    }
    @Override
    public String value() {
        return this.value;
    }
    public static EmployeeId of(String value) {
        return new EmployeeId(value);
    }
    public static Identity<String> next() {
        return new EmployeeId(String.format("%s%s%s",
                "emp",
                "2024-10-19",
                RandomUtil.getPositiveInt()));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeId that = (EmployeeId) o;
        return value.equals(that.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
