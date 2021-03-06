package com.sloydev.redbooth.interactor;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.TaskList;
import com.sloydev.redbooth.exception.RedboothException;
import com.sloydev.redbooth.repository.TaskListRepository;
import com.sloydev.redbooth.repository.TaskRepository;

import java.util.List;

import javax.inject.Inject;

public class CreateTaskInteractor implements Interactor {

    private final InteractorHandler interactorHandler;
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    private String name;
    private String description;
    private Boolean urgent;
    private Callback<Task> callback;
    private ErrorCallback errorCallback;

    @Inject public CreateTaskInteractor(InteractorHandler interactorHandler, TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.interactorHandler = interactorHandler;
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    public void createTask(String name, String description, Boolean urgent, Callback<Task> callback, ErrorCallback errorCallback) {
        this.name = name;
        this.description = description;
        this.urgent = urgent;
        this.callback = callback;
        this.errorCallback = errorCallback;
        interactorHandler.execute(this);
    }

    @Override public void run() {
        try {
            Task newTask = taskFromParameters();
            setupProjectAndList(newTask);
            saveNewTaskAndNotify(newTask);
        } catch (RedboothException e) {
            notifyError(e);
        }
    }

    private Task taskFromParameters() {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setCreated(System.currentTimeMillis());
        return task;
    }

    private void setupProjectAndList(Task newTask) {
        List<TaskList> taskLists = taskListRepository.getAll();
        if (!taskLists.isEmpty()) {
            TaskList taskList = taskLists.get(0);
            newTask.setProjectId(taskList.getProjectId());
            newTask.setTaskListId(taskList.getId());
            newTask.setUrgent(urgent);
        } else {
            throw new RedboothException("No task list found");
        }
    }

    private void saveNewTaskAndNotify(Task newTask) {
        Task createdTask = taskRepository.put(newTask);
        notifyLoaded(createdTask);
    }

    private void notifyLoaded(final Task createdTask) {
        interactorHandler.postResponse(new Runnable() {
            @Override public void run() {
                callback.onLoaded(createdTask);
            }
        });
    }

    private void notifyError(final RedboothException error) {
        interactorHandler.postResponse(new Runnable() {
            @Override public void run() {
                errorCallback.onError(error);
            }
        });
    }
}
