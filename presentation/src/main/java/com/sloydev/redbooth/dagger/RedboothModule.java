package com.sloydev.redbooth.dagger;

import com.sloydev.redbooth.RedboothApplication;
import com.sloydev.redbooth.data.dagger.DataModule;

import dagger.Module;

@Module(
        includes = {
                UiModule.class,
                DataModule.class,
        },
        complete = false
)
public class RedboothModule {

    public RedboothModule(RedboothApplication app) {

    }
}
