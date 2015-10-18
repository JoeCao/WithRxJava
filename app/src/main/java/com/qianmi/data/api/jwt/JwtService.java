package com.qianmi.data.api.jwt;

import android.app.IntentService;
import android.content.Intent;

import com.qianmi.data.api.Injector;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by caozupeng on 15/10/17.
 */
public class JwtService extends IntentService {
    @Inject
    JwtManager jwtManager;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public JwtService() {
        super(JwtService.class.getSimpleName());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ObjectGraph appGraph = Injector.obtain(getApplication());
        appGraph.inject(this);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        jwtManager.handleResult(intent);
    }
}
