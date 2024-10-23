package com.jackyfan.ddd.core.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 端口适配器：端口的实现，提供访问外部资源的具体技术实现，并通过依赖注入设置到领域服务或应用服务中。
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Adapter {
    PortType value();
}
