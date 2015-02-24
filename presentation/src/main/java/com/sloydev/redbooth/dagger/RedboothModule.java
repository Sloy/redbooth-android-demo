package com.sloydev.redbooth.dagger;

import com.sloydev.redbooth.RedboothApplication;

import dagger.Module;

@Module(
        includes = UiModule.class
)
public class RedboothModule {

    public RedboothModule(RedboothApplication app) {

    }
}
