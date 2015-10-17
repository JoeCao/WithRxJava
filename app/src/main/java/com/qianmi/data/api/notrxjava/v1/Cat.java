package com.qianmi.data.api.notrxjava.v1;

import android.graphics.Bitmap;

/**
 * Created by caozupeng on 15/10/14.
 */
public class Cat implements Comparable<Cat> {
    Bitmap image;
    int cuteness;

    @Override
    public int compareTo(Cat another) {
        if (cuteness == another.cuteness) {
            return 0;
        } else if (cuteness > another.cuteness) {
            return 1;
        } else {
            return -1;
        }
    }

}
