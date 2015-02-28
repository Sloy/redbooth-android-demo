package com.sloydev.redbooth.data.api;

import com.sloydev.redbooth.data.entity.TaskEntity;
import com.sloydev.redbooth.data.entity.TaskListEntity;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;

public interface RedboothApi {

    @GET("/tasks")
    public List<TaskEntity> getTasks();

    @GET("/task_lists")
    public List<TaskListEntity> getTaskLists();

    @POST("/tasks")
    public TaskEntity createNewTask(@Body TaskEntity taskEntity);
}
