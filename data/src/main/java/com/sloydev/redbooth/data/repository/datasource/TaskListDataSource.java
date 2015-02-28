package com.sloydev.redbooth.data.repository.datasource;

import com.sloydev.redbooth.data.entity.TaskListEntity;

import java.util.List;

public interface TaskListDataSource {

    List<TaskListEntity> getTaskLists();
}
