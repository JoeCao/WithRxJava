package com.qianmi;

import android.app.Application;

import com.qianmi.data.DataModule;
import com.qianmi.data.api.NewService;

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
                NewDemoApplication.class,
                NewService.class
        }
)
public class NewDemoModule {
    private final Application app;

    public NewDemoModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }
}
