package com.qianmi.data.api.notrxjava;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.dagger.Component;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.qianmi.NewDemoModule;
import com.qianmi.data.DataModule;
import com.qianmi.data.api.ApiModule;
import com.qianmi.data.api.NewService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Singleton;

import dagger.ObjectGraph;

/**
 * Created by caozupeng on 15/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class PriceChangeServiceTest extends AndroidTestCase {
    ObjectGraph objectGraph;
    NewService newService;

    @Before
    public void setUp() throws Exception {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        Application app = (Application)instrumentation.getTargetContext().getApplicationContext();
//        objectGraph = Injector.obtain(getContext());
//        objectGraph.inject(this);
//        ApiComponent component = DaggerPriceChangeServiceTest_ApiComponent.builder();
//        objectGraph = ObjectGraph.create(new DataModule());
//        objectGraph.inject(new ApiModule());
        objectGraph = ObjectGraph.create(new NewDemoModule(app));
//        newService = new NewService();
        newService = objectGraph.get(NewService.class);

    }

    @Test
    public void testApi() {
        newService.listPriceChanges();
    }
}
