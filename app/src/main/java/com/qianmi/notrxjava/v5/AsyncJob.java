package com.qianmi.notrxjava.v5;


import com.qianmi.notrxjava.v4.Callback;

/**
 * Created by caozupeng on 15/10/14.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}
