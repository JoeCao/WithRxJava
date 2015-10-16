package com.qianmi.notrxjava.v7;


import com.qianmi.notrxjava.v4.Callback;

/**
 * Func接口有两个类型成员，T对应于参数类型而R对应于返回类型
 * Created by caozupeng on 15/10/14.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callBack);

    public <R> AsyncJob<R> map(Func<T, R> func) {
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(Callback<R> callBack) {
                source.start(new Callback<T>() {
                    @Override
                    public void onResult(T result) {
                        R mapped = func.call(result);
                        callBack.onResult(mapped);
                    }

                    @Override
                    public void onError(Exception e) {
                        callBack.onError(e);
                    }
                });
            }
        };
    }

}
