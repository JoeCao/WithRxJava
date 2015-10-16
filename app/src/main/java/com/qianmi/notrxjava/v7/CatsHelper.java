package com.qianmi.notrxjava.v7;

import android.net.Uri;


import com.qianmi.notrxjava.v1.Cat;
import com.qianmi.notrxjava.v4.Callback;

import java.util.Collections;
import java.util.List;

/**
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
        AsyncJob<Uri> storedUriAsyncJob = new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> cutestCatCallback) {
                cutestCatAsyncJob.start(new Callback<Cat>() {
                    @Override
                    public void onResult(Cat cutest) {
                        apiWrapper.store(cutest)
                                .start(new Callback<Uri>() {
                                    @Override
                                    public void onResult(Uri result) {
                                        cutestCatCallback.onResult(result);
                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        cutestCatCallback.onError(e);
                                    }
                                });
                    }

                    @Override
                    public void onError(Exception e) {
                        cutestCatCallback.onError(e);
                    }
                });
            }
        };
        return storedUriAsyncJob;

    }


    /**
     * 前面的那些已经很赞了，但是创建AsyncJob<Uri> storedUriAsyncJob的部分还有些不忍直视。能在这里创建映射吗？我们来试试吧：
     * @param query
     * @return
     */
    public AsyncJob<Uri> saveTheCutestCat_error1(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });

        AsyncJob<Uri> storedUriAsyncJob = cutestCatAsyncJob.map(new Func<Cat, Uri>() {
            @Override
            public Uri call(Cat cat) {
//                return apiWrapper.store(cat);
                //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ will not compile
                //      Incompatible types:
                //      Required: Uri
                //      Found: AsyncJob<Uri>
                return null;
            }
        });
        return storedUriAsyncJob;
    }

    public AsyncJob<Uri> saveTheCutestCat_error2(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });

        AsyncJob<AsyncJob<Uri>> storedUriAsyncJob = cutestCatAsyncJob.map(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
//        return storedUriAsyncJob;
        //^^^^^^^^^^^^^^^^^^^^^^^ will not compile
        //      Incompatible types:
        //      Required: AsyncJob<Uri>
        //      Found: AsyncJob<AsyncJob<Uri>>
        return null;
    }



    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
