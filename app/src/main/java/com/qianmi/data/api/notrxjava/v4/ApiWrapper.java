package com.qianmi.data.api.notrxjava.v4;

import android.net.Uri;


import com.qianmi.data.api.notrxjava.v1.Cat;
import com.qianmi.data.api.notrxjava.v3.Api;

import java.util.List;

/**
 * Created by caozupeng on 15/10/14.
 */
public class ApiWrapper {
    Api api;

    public void queryCats(String query, Callback<List<Cat>> catsCallback) {
        api.queryCats(query, new Api.CatsQueryCallback() {

            @Override
            public void onCatListReceived(List<Cat> cats) {
                catsCallback.onResult(cats);
            }

            @Override
            public void onQueryFailed(Exception e) {
                catsCallback.onError(e);
            }
        });
    }

    public void store(Cat cat, Callback<Uri> uriCallback){
        api.store(cat, new Api.StoreCallback() {
            @Override
            public void onCatStored(Uri uri) {
                uriCallback.onResult(uri);
            }

            @Override
            public void onStoreFailed(Exception e) {
                uriCallback.onError(e);
            }
        });
    }
}
