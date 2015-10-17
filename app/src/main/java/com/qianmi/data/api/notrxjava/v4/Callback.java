package com.qianmi.data.api.notrxjava.v4;

/**
 * Created by caozupeng on 15/10/14.
 */
public interface Callback<T> {
    void onResult(T result);
    void onError(Exception e);
}
