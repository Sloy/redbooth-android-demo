package com.sloydev.redbooth.dagger;

import com.sloydev.redbooth.view.activity.LayoutContainerProvider;
import com.sloydev.redbooth.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
            MainActivity.class,
    }
)
public class UiModule {
    @Singleton @Provides LayoutContainerProvider provideLayoutContainerProvider() {
        return LayoutContainerProvider.DEFAULT;
    }
}
