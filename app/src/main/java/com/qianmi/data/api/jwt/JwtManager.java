package com.qianmi.data.api.jwt;

import com.f2prateek.rx.preferences.Preference;
import com.qianmi.data.api.IntentFactory;
import com.squareup.moshi.Moshi;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;

/**
 * Created by caozupeng on 15/10/17.
 */
public class JwtManager {
    IntentFactory intentFactory;
    OkHttpClient client;
    Moshi moshi;
    Preference<String> accessToken;

    @Inject
    public JwtManager(IntentFactory intentFactory, OkHttpClient client, Moshi moshi,
                      @AccessToken Preference<String> accessToken) {
        this.intentFactory = intentFactory;
        this.client = client;
        this.moshi = moshi;
        this.accessToken = accessToken;
    }
}
