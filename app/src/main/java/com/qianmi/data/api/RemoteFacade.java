package com.qianmi.data.api;

import com.qianmi.data.api.bean.Batch;
import com.qianmi.data.api.bean.BatchListResult;
import com.qianmi.data.api.bean.LoginRequest;
import com.qianmi.data.api.bean.PriceChangeListResult;
import com.qianmi.data.api.bean.ProductDetail;
import com.qianmi.data.api.bean.ProductListResult;
import com.qianmi.data.api.bean.Token;
import com.qianmi.data.api.bean.TradeDetail;
import com.qianmi.data.api.bean.TradeListResult;

import retrofit.Result;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by caozupeng on 15/10/16.
 */
public interface RemoteFacade {
    @GET("/changenotifys/")
    Observable<Result<PriceChangeListResult>> listPriceChanges(@Query("page") String page);

    @POST("/api-token-auth/")
    Observable<Result<Token>> authToken(@Body LoginRequest loginRequest);

    @GET("/batchs")
    Observable<Result<BatchListResult>> listBatchs(@Query("page") String page);

    @GET("/batchs/{batch_id}")
    Observable<Result<Batch>> fetchBatch(@Path("batch_id") String batchId);

    @GET("/supproducts")
    Observable<Result<ProductListResult>> listProducts(@Query("page") String page);

    @GET("/supproducts/{sku_id}")
    Observable<Result<ProductDetail>> fetchProduct(@Path("sku_id") String skuId);

    @GET("/trades/")
    Observable<Result<TradeListResult>> listTrades(@Query("page") String page);

    @GET("/trades/{trade_id}")
    Observable<Result<TradeDetail>> fetchTrade(@Path("trade_id")String tradeId);


}
