package com.sloydev.redbooth.dagger;

import android.app.Application;

import com.sloydev.redbooth.RedboothApplication;
import com.sloydev.redbooth.data.dagger.DataModule;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                UiModule.class,
                DataModule.class,
        },
        complete = false
)
public class RedboothModule {

    private RedboothApplication app;

    public RedboothModule(RedboothApplication app) {
        this.app = app;
    }

    @Provides Application provideApplication() {
        return app;
    }

}
