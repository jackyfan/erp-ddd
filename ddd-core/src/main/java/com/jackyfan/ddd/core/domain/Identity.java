package com.jackyfan.ddd.core.domain;

import java.io.Serializable;

public interface Identity<T> extends Serializable {
    T value();
}
