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
        taskModel.setTitle(task.getTitle());
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
