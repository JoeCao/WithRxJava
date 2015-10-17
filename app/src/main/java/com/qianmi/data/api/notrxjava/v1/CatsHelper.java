package com.qianmi.data.api.notrxjava.v1;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

/**
 * 唉，这样清晰简单的代码帅到让我窒息啊。来理清一下代码的炫酷之处吧。
 * 主方法 saveTheCutestCat 只包含了 3 个其它方法
 * 然后花个几分钟来看看代码和思考这些方法。你给方法提供了输入参数然后就能得到结果返回了，
 * 在这个方法工作的时候我们需要等待它的完成。
 * 简洁而有用，让我们再看看组合方法的其它优势：
 * <p>
 * 组合
 * <p>
 * 正如我们看到的，根据其它 3 个方法而新创建了一个方法（saveTheCutestCat），因此我们组合了它们。
 * 像乐高积木那样，我们把方法之间连接起来组成了乐高积木（实际上可以在之后组合起来）。
 * 组合方法是很简单的，从一个方法得到返回结果然后再把它传递给另外的方法做为输入参数，这不简单吗？
 * <p>
 * Created by caozupeng on 15/10/14.
 */
public class CatsHelper {
    Api api;
    Uri defaultValue = null;

    public Uri saveTehCutestCat(String query) {
        try {
            List<Cat> cats = api.queryCats(query);
            Cat cutest = findCutest(cats);
            Uri saveUri = api.store(cutest);
            return saveUri;
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;

        }
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
