package com.sloydev.redbooth.dagger;

import com.sloydev.redbooth.presenter.TaskListPresenter;
import com.sloydev.redbooth.view.activity.TaskCreateActivity;
import com.sloydev.redbooth.view.activity.base.LayoutContainerProvider;
import com.sloydev.redbooth.view.activity.LoginActivity;

import com.sloydev.redbooth.view.activity.TaskListActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                LoginActivity.class, TaskListActivity.class, TaskListPresenter.class, TaskCreateActivity.class
        },
        complete = false
)
public class UiModule {
    @Singleton @Provides LayoutContainerProvider provideLayoutContainerProvider() {
        return LayoutContainerProvider.DEFAULT;
    }
}
