package com.qianmi.data.api.jwt;

import android.app.Application;
import android.content.Intent;

import com.f2prateek.rx.preferences.Preference;
import com.qianmi.data.IntentFactory;
import com.qianmi.ui.LoginActivity;
import com.squareup.moshi.Moshi;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by caozupeng on 15/10/17.
 */
@Singleton
public class JwtManager {
    IntentFactory intentFactory;
    OkHttpClient client;
    Moshi moshi;
    Preference<String> accessToken;
    Application context;

    @Inject
    public JwtManager(Application context, IntentFactory intentFactory, OkHttpClient client, Moshi moshi,
                      @AccessToken Preference<String> accessToken) {
        this.context = context;
        this.intentFactory = intentFactory;
        this.client = client;
        this.moshi = moshi;
        //AccessToken是注入的单例
        this.accessToken = accessToken;
    }

    public Intent createLoginIntent() {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    /**
     * 从返回的结果中提取Jwt的token值
     *
     * @param returnIntent
     */
    public void handleResult(Intent returnIntent) {
        String token = returnIntent.getStringExtra("token");
        accessToken.set(token);
    }

}
