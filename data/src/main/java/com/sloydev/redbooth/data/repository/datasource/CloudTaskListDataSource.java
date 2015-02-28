package com.sloydev.redbooth.data.repository.datasource;

import com.sloydev.redbooth.data.api.RedboothApi;
import com.sloydev.redbooth.data.entity.TaskListEntity;

import java.util.List;

import javax.inject.Inject;

public class CloudTaskListDataSource implements TaskListDataSource {

    private final RedboothApi redboothApi;

    @Inject public CloudTaskListDataSource(RedboothApi redboothApi) {
        this.redboothApi = redboothApi;
    }

    @Override public List<TaskListEntity> getTaskLists() {
        return redboothApi.getTaskLists();
    }
}
