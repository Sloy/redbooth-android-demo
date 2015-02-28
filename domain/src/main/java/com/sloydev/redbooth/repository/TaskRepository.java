package com.sloydev.redbooth.repository;

import com.sloydev.redbooth.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> getAll();

    Task put(Task task);
}
