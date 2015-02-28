package com.sloydev.redbooth.data.repository;

import com.sloydev.redbooth.TaskList;
import com.sloydev.redbooth.data.entity.mapper.TaskListEntityMapper;
import com.sloydev.redbooth.data.repository.datasource.TaskListDataSource;
import com.sloydev.redbooth.repository.TaskListRepository;

import java.util.List;

import javax.inject.Inject;

public class TaskListDataRepository implements TaskListRepository {

    private final TaskListDataSource taskListDataSource;
    private final TaskListEntityMapper taskListEntityMapper;

    @Inject public TaskListDataRepository(TaskListDataSource taskListDataSource, TaskListEntityMapper taskListEntityMapper) {
        this.taskListDataSource = taskListDataSource;
        this.taskListEntityMapper = taskListEntityMapper;
    }

    @Override public List<TaskList> getAll() {
        return taskListEntityMapper.transform(taskListDataSource.getTaskLists());
    }
}
