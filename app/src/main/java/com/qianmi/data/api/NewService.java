package com.qianmi.data.api;

import android.util.Log;

import com.f2prateek.rx.preferences.Preference;
import com.qianmi.data.api.bean.LoginRequest;
import com.qianmi.data.api.bean.PriceChange;
import com.qianmi.data.api.bean.PriceChangeListResult;
import com.qianmi.data.api.bean.Token;
import com.qianmi.data.api.jwt.AccessToken;

import java.util.List;

import javax.inject.Inject;

import retrofit.Result;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by caozupeng on 15/10/19.
 */
public class NewService {
    private static final String TAG = "NewService";
    @Inject
    RemoteInterface remoteInterface;
    @Inject
    @AccessToken
    Preference<String> accessToken;
    private final CompositeSubscription subscriptions = new CompositeSubscription();


    public void listPriceChanges() {
        Observable<Result<PriceChangeListResult>> ret = remoteInterface.listPriceChanges(null).share();
        subscriptions.add(ret.filter(Results.isSuccess())
                .flatMap(result -> {
                    PriceChangeListResult pResult = result.response().body();
                    List<PriceChange> list = pResult.results;
                    Log.d(TAG, "size is " + list.size());
                    return Observable.from(list);
                })
                .subscribe(priceChange -> {
                    Log.d(TAG, priceChange.gonghuo_product_name);
                }));
        subscriptions.add(ret.filter(Funcs.not(Results.isSuccess())).subscribe(result -> {
            Log.e(TAG, result.response().message());
        }));


    }

    public void auth() {
        Observable<Result<Token>> ret = remoteInterface.authToken(new LoginRequest("caozupeng", "caozupeng"));
        subscriptions.add(ret.filter(Results.isSuccess()).map(result -> {
            Token token = result.response().body();
            return token;
        }).subscribe(token -> {
            Log.d(TAG, "token is " + token.token);
            accessToken.set(token.token);
        }));
    }
}
