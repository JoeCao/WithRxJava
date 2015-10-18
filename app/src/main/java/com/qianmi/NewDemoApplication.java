package com.qianmi;

import dagger.ObjectGraph;

/**
 * Created by caozupeng on 15/10/18.
 */
public class NewDemoApplication extends android.app.Application {
    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create();

    }


}
