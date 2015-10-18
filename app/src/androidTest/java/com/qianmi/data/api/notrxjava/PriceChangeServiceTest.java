package com.qianmi.data.api.notrxjava;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.dagger.Component;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.qianmi.NewDemoApplication;
import com.qianmi.data.api.ApiModule;
import com.qianmi.data.api.PriceChangeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.ObjectGraph;

/**
 * Created by caozupeng on 15/10/17.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class PriceChangeServiceTest extends AndroidTestCase{
    @Inject
    PriceChangeService priceChangeService;
    ObjectGraph objectGraph;
    @Singleton
    @Component(modules = ApiModule.class)
    public interface TestComponent {
        void inject(PriceChangeServiceTest priceChangeServiceTest);
    }

    @Before
    public void setUp() throws Exception {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        NewDemoApplication app = (NewDemoApplication) instrumentation.getTargetContext().getApplicationContext();
        TestComponent component;
//        super.setUp();

//        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
//        objectGraph = ObjectGraph.create(new NewDemoModule(getInstrumentation().getContext()));
//        objectGraph.inject(this);
//        DaggerBaseLayerComponent.builder();
    }

    @Test
    public void testApi() {
        priceChangeService.listPriceChanges().subscribe();
    }
}
