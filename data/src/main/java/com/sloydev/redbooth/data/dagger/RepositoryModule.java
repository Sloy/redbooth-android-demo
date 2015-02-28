package com.sloydev.redbooth.data.dagger;

import com.sloydev.redbooth.data.repository.TaskDataRepository;
import com.sloydev.redbooth.data.repository.datasource.CloudTaskDataSource;
import com.sloydev.redbooth.data.repository.datasource.TaskDataSource;
import com.sloydev.redbooth.repository.TaskRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                ApiModule.class,
        },
        injects = {
                CloudTaskDataSource.class, TaskDataRepository.class,
        },
        library = true,
        complete = false
)
public class RepositoryModule {

    @Provides
    @Singleton TaskRepository provideTaskRepository(TaskDataRepository taskRepository) {
        return taskRepository;
    }

    @Provides @Singleton TaskDataSource provideTaskDataSource(CloudTaskDataSource taskDataSource) {
        return taskDataSource;
    }
}
