package com.jackyfan.ddd.core.domain;

import com.jackyfan.ddd.core.domain.Identity;

public interface RandomIdentity<T> extends Identity<T> {
    T next();
}
