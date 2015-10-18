package com.qianmi;

import android.support.annotation.NonNull;

import com.qianmi.data.api.Injector;

import dagger.ObjectGraph;

/**
 * Created by caozupeng on 15/10/18.
 */
public class NewDemoApplication extends android.app.Application {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new NewDemoModule(this));
        objectGraph.inject(this);

    }

    public Object getSystemService(@NonNull String name) {
        if (Injector.matchesService(name)) {
            return objectGraph;
        }
        return super.getSystemService(name);
    }

}
