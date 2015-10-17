package com.qianmi.data.api.notrxjava.v5;


import com.qianmi.data.api.notrxjava.v4.Callback;

/**
 * Created by caozupeng on 15/10/14.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
