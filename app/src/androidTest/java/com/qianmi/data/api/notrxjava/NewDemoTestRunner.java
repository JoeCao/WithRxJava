package com.qianmi.data.api.notrxjava;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.support.test.runner.AndroidJUnitRunner;

import static android.content.Context.KEYGUARD_SERVICE;
import static android.content.Context.POWER_SERVICE;
import static android.os.PowerManager.ACQUIRE_CAUSES_WAKEUP;
import static android.os.PowerManager.FULL_WAKE_LOCK;
import static android.os.PowerManager.ON_AFTER_RELEASE;

/**
 * Created by caozupeng on 15/10/18.
 */
public class NewDemoTestRunner extends AndroidJUnitRunner {
    private PowerManager.WakeLock wakeLock;

    @Override
    public void onStart() {
        // Inform the app we are an instrumentation test before the object graph is initialized.
//        ApiModule.instrumentationTest = true;

        Context app = getTargetContext().getApplicationContext();

        String name = NewDemoTestRunner.class.getSimpleName();
        // Unlock the device so that the tests can input keystrokes.
//        KeyguardManager keyguard = (KeyguardManager) app.getSystemService(KEYGUARD_SERVICE);
//        keyguard.newKeyguardLock(name).disableKeyguard();
        // Wake up the screen.
//        PowerManager power = (PowerManager) app.getSystemService(POWER_SERVICE);
//        wakeLock = power.newWakeLock(FULL_WAKE_LOCK | ACQUIRE_CAUSES_WAKEUP | ON_AFTER_RELEASE, name);
//        wakeLock.acquire();

        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        wakeLock.release();
    }
}
