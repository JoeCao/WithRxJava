package com.qianmi.data.api.notrxjava.v8;

import android.net.Uri;

import com.qianmi.data.api.notrxjava.v1.Cat;
import com.qianmi.data.api.notrxjava.v7.Func;

import java.util.Collections;
import java.util.List;

/**
 * 在目前这点上我们只能有AsyncJob<AsyncJob<Uri>>。
 * 我们需要往更深处挖吗？我们希望的是，去把AsyncJob在一个级别上的两个异步操作扁平化成一个单一的异步操作
 * Created by caozupeng on 15/10/14.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;


    public AsyncJob<Uri> saveTheCutestCat(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });

        AsyncJob<Uri> storedUriAsyncJob = cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
        return storedUriAsyncJob;
    }

    public AsyncJob<Uri> betterTheCutestCat(String query) {
        return apiWrapper.queryCats(query).map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        }).flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
    }

    /**
     * 用lambda表达式和链式写法
     * @param query
     * @return
     */
    public AsyncJob<Uri> bestTheCutestCat(String query) {
        return apiWrapper.queryCats(query)
                .map(cats -> findCutest(cats))
                .flatMap(cat -> apiWrapper.store(cat));
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
