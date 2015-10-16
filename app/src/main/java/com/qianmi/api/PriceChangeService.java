package com.qianmi.api;

import com.qianmi.api.bean.PriceChangeListResult;

import retrofit.Result;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by caozupeng on 15/10/16.
 */
public interface PriceChangeService {
    @GET("/search/changenotifys/")
    Observable<Result<PriceChangeListResult>> listPriceChanges();
}
