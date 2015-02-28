package com.sloydev.redbooth.interactor;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.repository.TaskRepository;

import javax.inject.Inject;

public class CreateTaskInteractor implements Interactor {

    private final InteractorHandler interactorHandler;
    private final TaskRepository taskRepository;

    private String name;
    private String description;
    private Callback<Task> callback;

    @Inject public CreateTaskInteractor(InteractorHandler interactorHandler, TaskRepository taskRepository) {
        this.interactorHandler = interactorHandler;
        this.taskRepository = taskRepository;
    }

    public void createTask(String name, String description, Callback<Task> callback) {
        this.name = name;
        this.description = description;
        this.callback = callback;
        interactorHandler.execute(this);
    }

    @Override public void run() {
        Task newTask = taskFromParameters();
        Task createdTask = taskRepository.put(newTask);
        notifyLoaded(createdTask);
    }

    private Task taskFromParameters() {
        Task task = new Task();
        task.setName(name);
        task.setDescription(name);
        task.setCreated(System.currentTimeMillis());
        return task;
    }

    private void notifyLoaded(final Task createdTask) {
        interactorHandler.postResponse(new Runnable() {
            @Override public void run() {
                callback.onLoaded(createdTask);
            }
        });
    }
}
