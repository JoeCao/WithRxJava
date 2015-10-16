package com.qianmi.notrxjava.v3;

import android.net.Uri;


import com.qianmi.notrxjava.v1.Cat;

import java.util.Collections;
import java.util.List;

/**
 * 这很糟糕！现在它有了更多无关代码和花括号，但是逻辑是一样的。
 * <p>
 * 那么组合在哪呢？他已经不见了！现在你不能像之前那样组合操作了。
 * 对于每一个异步操作你都必须创建出回调接口并在代码中插入它们，每一次都需要手动地加入！
 * <p>
 * 错误传递又在哪？又是一个否定！在这样的代码中错误不会自动地传递，
 * 我们需要在更深一层上通过自己手动地再让它传递下去（请看onStoreFailed和onQueryFailed方法）。
 * <p>
 * 我们很难对这样的代码进行阅读和找出潜在的 bugs。
 * Created by caozupeng on 15/10/14.
 */
public class CatsHelper {
    public interface CutestCatCallback {
        void onCutestCatSaved(Uri uri);

        void onError(Exception e);
    }

    Api api;

    public void saveTheCutestCat(String query, CutestCatCallback cutestCatCallback) {
        api.queryCats(query, new Api.CatsQueryCallback() {

            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                api.store(cutest, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(Uri uri) {
                        cutestCatCallback.onCutestCatSaved(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        cutestCatCallback.onError(e);
                    }
                });
            }

            @Override
            public void onQueryFailed(Exception e) {

            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
