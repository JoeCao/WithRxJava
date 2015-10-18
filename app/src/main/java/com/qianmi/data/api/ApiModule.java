package com.qianmi.data.api;

import com.qianmi.data.api.jwt.JwtInterceptor;
import com.qianmi.data.api.jwt.JwtService;
import com.squareup.moshi.Moshi;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.MoshiConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

@Module(
        complete = false,
        library = true,
        injects = {
                JwtService.class
        }
)
public final class ApiModule {
    public static final HttpUrl PRODUCTION_API_URL = HttpUrl.parse("http://frey.sj001.com");

    @Provides
    @Singleton
    HttpUrl provideBaseUrl() {
        return PRODUCTION_API_URL;
    }

    @Provides
    @Singleton
    @Named("Api")
    OkHttpClient provideApiClient(OkHttpClient client,
                                  JwtInterceptor oauthInterceptor) {
        return createApiClient(client, oauthInterceptor);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(HttpUrl baseUrl, @Named("Api") OkHttpClient client, Moshi moshi) {
        return new Retrofit.Builder() //
                .client(client) //
                .baseUrl(baseUrl) //
                .addConverterFactory(MoshiConverterFactory.create(moshi)) //
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //
                .build();
    }

    @Provides
    @Singleton
    PriceChangeService providePriceChangeService(Retrofit retrofit) {
        return retrofit.create(PriceChangeService.class);
    }

    static OkHttpClient createApiClient(OkHttpClient client, JwtInterceptor oauthInterceptor) {
        client = client.clone();
        client.interceptors().add(oauthInterceptor);
        return client;
    }
}
