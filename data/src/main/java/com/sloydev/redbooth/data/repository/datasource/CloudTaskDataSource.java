package com.sloydev.redbooth.data.repository.datasource;

import com.sloydev.redbooth.data.api.RedboothApi;
import com.sloydev.redbooth.data.entity.TaskEntity;
import com.sloydev.redbooth.exception.RedboothException;

import java.util.List;

import javax.inject.Inject;

public class CloudTaskDataSource implements TaskDataSource {

    private final RedboothApi redboothApi;

    @Inject public CloudTaskDataSource(RedboothApi redboothApi) {
        this.redboothApi = redboothApi;
    }

    @Override public List<TaskEntity> getTasks() {
        return redboothApi.getTasks();
    }

    @Override public TaskEntity createTask(TaskEntity taskEntity) {
        try {
            return redboothApi.createNewTask(taskEntity);
        } catch (Exception e) {
            throw new RedboothException(e);
        }
    }
}
