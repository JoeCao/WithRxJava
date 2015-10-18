package com.qianmi;

import android.app.Application;

import com.qianmi.data.DataModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by caozupeng on 15/10/18.
 */

@Module(
        includes = {
                DataModule.class
        },
        injects = {
                NewDemoApplication.class
        }
)
public class NewDemoModule {
    private final NewDemoApplication app;

    public NewDemoModule(NewDemoApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }
}
