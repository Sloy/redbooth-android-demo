package com.sloydev.redbooth.model.mapper;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TaskModelMapper {

    @Inject public TaskModelMapper() {
    }

    public TaskModel transform(Task task) {
        TaskModel taskModel = new TaskModel();
        taskModel.setName(task.getName());
        taskModel.setDescription(task.getDescription());
        taskModel.setCreatedTimestamp(task.getCreated());
        taskModel.setUrgent(task.isUrgent());
        return taskModel;
    }

    public List<TaskModel> transform(List<Task> tasks) {
        List<TaskModel> taskModels = new ArrayList<>();
        for (Task task : tasks) {
            taskModels.add(transform(task));
        }
        return taskModels;
    }
}
