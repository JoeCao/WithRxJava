package com.qianmi.data.api.withrxjava;

import android.net.Uri;

import com.qianmi.data.api.notrxjava.v1.Cat;

import java.util.Collections;
import java.util.List;

import rx.Observable;

/**
 * Created by caozupeng on 15/10/16.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;

    public Observable<Uri> saveTheCutestCat(String query) {
        return apiWrapper.queryCats(query)
                .map(cats -> CatsHelper.this.findCutest(cats))
                .flatMap(cat -> apiWrapper.store(cat));
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
