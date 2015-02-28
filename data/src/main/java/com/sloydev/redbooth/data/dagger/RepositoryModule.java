package com.sloydev.redbooth.data.dagger;

import com.sloydev.redbooth.data.repository.TaskDataRepository;
import com.sloydev.redbooth.data.repository.TaskListDataRepository;
import com.sloydev.redbooth.data.repository.datasource.CloudTaskDataSource;
import com.sloydev.redbooth.data.repository.datasource.CloudTaskListDataSource;
import com.sloydev.redbooth.data.repository.datasource.TaskDataSource;
import com.sloydev.redbooth.data.repository.datasource.TaskListDataSource;
import com.sloydev.redbooth.repository.TaskListRepository;
import com.sloydev.redbooth.repository.TaskRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        includes = {
                ApiModule.class,
        },
        injects = {
                CloudTaskDataSource.class, TaskDataRepository.class, TaskListDataRepository.class, CloudTaskListDataSource.class,
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

    @Provides @Singleton TaskListRepository provideTaskListRepository(TaskListDataRepository taskListDataRepository) {
        return taskListDataRepository;
    }

    @Provides @Singleton TaskListDataSource provideTaskListDataSource(CloudTaskListDataSource cloudTaskListDataSource) {
        return cloudTaskListDataSource;
    }
}
