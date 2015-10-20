package com.qianmi.data.api;

import android.support.annotation.Nullable;

import com.qianmi.data.api.bean.LoginRequest;
import com.qianmi.data.api.bean.PriceChangeListResult;
import com.qianmi.data.api.bean.Token;

import retrofit.Result;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by caozupeng on 15/10/16.
 */
public interface RemoteInterface {
    @GET("/changenotifys/")
    Observable<Result<PriceChangeListResult>> listPriceChanges(@Query("page") String page);

    @POST("/api-token-auth/")
    Observable<Result<Token>> authToken(@Body LoginRequest loginRequest);


}
