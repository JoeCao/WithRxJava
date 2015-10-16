package com.qianmi.notrxjava.v2;

import android.net.Uri;


import com.qianmi.notrxjava.v1.Cat;

import java.util.Collections;
import java.util.List;

/**
 * 开始异步嵌套了
 * Created by caozupeng on 15/10/14.
 */
public class CatsHelper {
    public interface CutestCatCallback {
        void onCutestCatSaved(Uri uri);

        void onError(Exception e);
    }

    Api api;

    public void savedTheCutestCat(String query, CutestCatCallback cutestCatCallback) {
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                Uri savedUri = api.store(cutest);
                cutestCatCallback.onCutestCatSaved(savedUri);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
