package com.sloydev.redbooth.data.repository;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.data.entity.mapper.TaskEntityMapper;
import com.sloydev.redbooth.data.repository.datasource.TaskDataSource;
import com.sloydev.redbooth.repository.TaskRepository;

import java.util.List;

import javax.inject.Inject;

public class TaskDataRepository implements TaskRepository {

    private final TaskEntityMapper taskEntityMapper;
    private final TaskDataSource taskDataSource;

    @Inject public TaskDataRepository(TaskEntityMapper taskEntityMapper, TaskDataSource taskDataSource) {
        this.taskEntityMapper = taskEntityMapper;
        this.taskDataSource = taskDataSource;
    }

    @Override public List<Task> getAll() {
        return taskEntityMapper.transform(taskDataSource.getTasks());
    }

    @Override public Task put(Task task) {
        return task;
    }
}
