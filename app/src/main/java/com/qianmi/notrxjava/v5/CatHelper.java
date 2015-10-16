package com.qianmi.notrxjava.v5;


import android.net.Uri;


import com.qianmi.notrxjava.v1.Cat;
import com.qianmi.notrxjava.v4.Callback;

import java.util.Collections;
import java.util.List;

/**
 * 之前的版本更简单些啊，我们现在的优势是什么？答案就是现在我们可以给客户端返回“组合”操作的AsyncJob<Uri>
 * Created by caozupeng on 15/10/14.
 */
public class CatHelper {
    ApiWrapper apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> callback) {
                apiWrapper.queryCats(query).start(new Callback<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        Cat cutest = findCutest(result);
                        apiWrapper.store(cutest).start(new Callback<Uri>() {
                            @Override
                            public void onResult(Uri result) {
                                callback.onResult(result);
                            }

                            @Override
                            public void onError(Exception e) {
                                callback.onError(e);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
