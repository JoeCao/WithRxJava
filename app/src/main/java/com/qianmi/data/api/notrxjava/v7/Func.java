package com.qianmi.data.api.notrxjava.v7;

/**
 * Created by caozupeng on 15/10/14.
 */
public interface Func<T, R> {
    R call(T t);
}
