package com.qianmi.data.api.notrxjava.v6;

import android.net.Uri;


import com.qianmi.data.api.notrxjava.v1.Cat;
import com.qianmi.data.api.notrxjava.v4.Callback;
import com.qianmi.data.api.notrxjava.v5.ApiWrapper;
import com.qianmi.data.api.notrxjava.v5.AsyncJob;

import java.util.Collections;
import java.util.List;

/**
 * 代码量多了许多，但是更加清晰了。低层次嵌套的回调，利于理解的变量名
 * catsListAsyncJob、cutestCatAsyncJob、storedUriAsyncJob
 * Created by caozupeng on 15/10/14.
 */
public class CatHelper {
    ApiWrapper apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = new AsyncJob<Cat>() {
            public void start(Callback<Cat> callback) {
                catsListAsyncJob.start(new Callback<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        callback.onResult(findCutest(result));
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
        AsyncJob<Uri> storeUriAsyncJob = new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> callback) {
                cutestCatAsyncJob.start(new Callback<Cat>() {
                    @Override
                    public void onResult(Cat result) {
                        apiWrapper.store(result)
                                .start(new Callback<Uri>() {
                                    @Override
                                    public void onResult(Uri result) {
                                        callback.onResult(result);
                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        callback.onError(e);
                                    }
                                });
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
        return storeUriAsyncJob;
    }


    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
