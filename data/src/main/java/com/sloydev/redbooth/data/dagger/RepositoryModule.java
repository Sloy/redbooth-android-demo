package com.sloydev.redbooth.data.dagger;

import com.sloydev.redbooth.data.repository.DummyTaskRepository;
import com.sloydev.redbooth.repository.TaskRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    library = true
)
public class RepositoryModule {

    @Provides
    @Singleton TaskRepository provideTaskRepository(DummyTaskRepository taskRepository) {
        return taskRepository;
    }

}
