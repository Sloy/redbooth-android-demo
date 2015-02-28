package com.sloydev.redbooth.data.entity.mapper;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.data.entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TaskEntityMapper {
    @Inject public TaskEntityMapper() {
    }

    public Task transform(TaskEntity entity) {
        Task task = new Task();
        task.setId(entity.getId());
        task.setName(entity.getName());
        task.setDescription(entity.getDescription());
        task.setCreated(entity.getCreated_at());
        return task;
    }

    public List<Task> transform(List<TaskEntity> taskEntities) {
        List<Task> tasks = new ArrayList<>(taskEntities.size());
        for (TaskEntity taskEntity : taskEntities) {
            tasks.add(transform(taskEntity));
        }
        return tasks;
    }
}
