package com.qianmi.notrxjava.v3;

import android.net.Uri;


import com.qianmi.notrxjava.v1.Cat;

import java.util.List;

/**
 * Created by caozupeng on 15/10/14.
 */
public interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);

        void onQueryFailed(Exception e);
    }

    interface StoreCallback {
        void onCatStored(Uri uri);

        void onStoreFailed(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);

    void store(Cat cat, StoreCallback storeCallback);

}

