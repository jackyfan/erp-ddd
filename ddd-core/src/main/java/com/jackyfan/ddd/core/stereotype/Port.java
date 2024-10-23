package com.jackyfan.ddd.core.stereotype;

import com.jackyfan.ddd.core.stereotype.PortType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 端口：
 * 作为访问外部资源的抽象。常见端口包括对访问数据库的抽象，定义为资源库端口；
 * 对调用第三方服务包括上游限界上下文的抽象，定义为客户端端口；
 * 对发布事件到事件总线的抽象，定义为发布者端口。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Port {
    PortType value();
}
