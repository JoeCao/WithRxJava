package com.qianmi.notrxjava.v1;

import android.net.Uri;

import java.util.List;

/**
 * Created by caozupeng on 15/10/14.
 */
public interface Api {
    List<Cat> queryCats(String query);

    Uri store(Cat cat);
}
