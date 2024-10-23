package com.jackyfan.ddd.core.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 远程应用服务：若为当前限界上下文的远程服务，则负责响应角色的服务请求；若为上游限界上下文的远程服务，则响应客户端适配器的调用请求。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Remote {
    RemoteType value();
}
