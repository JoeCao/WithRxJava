package com.qianmi.data.api.notrxjava.v4;

import android.net.Uri;


import com.qianmi.data.api.notrxjava.v1.Cat;

import java.util.Collections;
import java.util.List;

/**
 * 比之前的简明了一些。
 * 我们可以通过直接传递一个顶级的cutestCatCallback回调接口给apiWrapper.store来减少回调间的层级调用，
 * 此外作为回调方法的签名是一样的。
 * Created by caozupeng on 15/10/14.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;

    public void saveTheCutestCat(String query, Callback<Uri> cutestCatCallback) {
        apiWrapper.queryCats(query, new Callback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                apiWrapper.store(cutest, cutestCatCallback);
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
