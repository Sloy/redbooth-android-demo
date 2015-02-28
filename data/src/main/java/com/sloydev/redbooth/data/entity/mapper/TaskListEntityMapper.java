package com.sloydev.redbooth.data.entity.mapper;

import com.sloydev.redbooth.TaskList;
import com.sloydev.redbooth.data.entity.TaskListEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TaskListEntityMapper {
    @Inject public TaskListEntityMapper() {
    }

    public TaskList transform(TaskListEntity entity) {
        TaskList taskList = new TaskList();
        taskList.setId(entity.getId());
        taskList.setName(entity.getName());
        taskList.setProjectId(entity.getProject_id());
        return taskList;
    }

    public List<TaskList> transform(List<TaskListEntity> taskListEntities) {
        List<TaskList> taskLists = new ArrayList<>(taskListEntities.size());
        for (TaskListEntity taskListEntity : taskListEntities) {
            taskLists.add(transform(taskListEntity));
        }
        return taskLists;
    }
}
