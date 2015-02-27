package com.sloydev.redbooth.interactor;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.repository.TaskRepository;

import java.util.List;

import javax.inject.Inject;

public class GetTaskListInteractor implements Interactor {

    private final InteractorHandler interactorHandler;
    private final TaskRepository taskRepository;

    private Callback<List<Task>> callback;

    @Inject public GetTaskListInteractor(InteractorHandler interactorHandler, TaskRepository taskRepository) {
        this.interactorHandler = interactorHandler;
        this.taskRepository = taskRepository;
    }

    public void loadTaskList(Callback<List<Task>> callback) {
        this.callback = callback;
        interactorHandler.execute(this);
    }

    @Override public void run() {
        List<Task> tasks = taskRepository.getAll();
        notifyLoaded(tasks);
    }

    private void notifyLoaded(final List<Task> tasks) {
        interactorHandler.postResponse(new Runnable() {
            @Override public void run() {
                callback.onLoaded(tasks);
            }
        });
    }

}
