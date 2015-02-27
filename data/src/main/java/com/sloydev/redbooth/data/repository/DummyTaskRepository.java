package com.sloydev.redbooth.data.repository;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DummyTaskRepository implements TaskRepository {

    @Inject public DummyTaskRepository() {
    }

    @Override public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(dummyTask());
        tasks.add(dummyTask());
        tasks.add(dummyTask());
        tasks.add(dummyTask());
        tasks.add(dummyTask());
        return tasks;
    }

    private Task dummyTask() {
        Task task = new Task();
        task.setName("This is the title");
        task.setDescription("Description for the task.\nBut a long one, you know.");
        return task;
    }
}
