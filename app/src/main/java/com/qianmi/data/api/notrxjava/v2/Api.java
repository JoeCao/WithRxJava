package com.qianmi.data.api.notrxjava.v2;

/**
 * Created by caozupeng on 15/10/14.
 */

import android.net.Uri;

import com.qianmi.data.api.notrxjava.v1.Cat;

import java.util.List;


public interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);

        void onError(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);

    Uri store(Cat cat);
}
