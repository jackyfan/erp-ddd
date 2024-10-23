package com.jackyfan.ddd.core.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 聚合根：作为信息的持有者，履行自给自足的领域行为，内部实体与值对象之间的协作被聚合边界隐藏起来。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Aggregate {
}
