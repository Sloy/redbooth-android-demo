package com.sloydev.redbooth.data.repository.datasource;

import com.sloydev.redbooth.data.entity.TaskEntity;

import java.util.List;

public interface TaskDataSource {

    public List<TaskEntity> getTasks();
}
