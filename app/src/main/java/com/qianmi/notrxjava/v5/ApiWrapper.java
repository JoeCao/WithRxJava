package com.qianmi.notrxjava.v5;

import android.net.Uri;


import com.qianmi.notrxjava.v1.Cat;
import com.qianmi.notrxjava.v3.Api;
import com.qianmi.notrxjava.v4.Callback;

import java.util.List;

/**
 * Created by caozupeng on 15/10/14.
 */
public class ApiWrapper {
    Api api;

    public AsyncJob<List<Cat>> queryCats(String query) {
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(Callback<List<Cat>> callback) {
                api.queryCats(query, new Api.CatsQueryCallback() {

                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        callback.onResult(cats);
                    }

                    @Override
                    public void onQueryFailed(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }

    public AsyncJob<Uri> store(Cat cat) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> callback) {
                api.store(cat, new Api.StoreCallback() {

                    @Override
                    public void onCatStored(Uri uri) {
                        callback.onResult(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
}
