package com.sloydev.redbooth.data.dagger;

import com.sloydev.redbooth.data.executor.InteractorExecutor;
import com.sloydev.redbooth.interactor.GetTaskListInteractor;
import com.sloydev.redbooth.interactor.InteractorHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                RepositoryModule.class,
        },
        injects = {
                GetTaskListInteractor.class,
        },
        library = true,
        complete = false
)
public class DataModule {
    @Provides @Singleton InteractorHandler provideInteractorHandler(InteractorExecutor interactorExecutor) {
        return interactorExecutor;
    }
}
