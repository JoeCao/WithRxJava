package com.qianmi.ui;

import dagger.Module;

/**
 * 决定Inject应用的范围，需要将Activity和Fragment都放到这里
 * Created by caozupeng on 15/10/22.
 */
@Module(
        injects = {
                MainActivity.class,
        },
        complete = false,
        library = true
)
public class UIModule {
}
