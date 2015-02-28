package com.sloydev.redbooth.data.api;

import com.sloydev.redbooth.data.entity.TaskEntity;

import java.util.List;

import retrofit.http.GET;

public interface RedboothApi {

    @GET("/tasks")
    public List<TaskEntity> getTasks();

}
