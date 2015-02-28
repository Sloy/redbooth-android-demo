package com.sloydev.redbooth.interactor;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.TaskList;
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
    private Callback<Task> callback;

    @Inject public CreateTaskInteractor(InteractorHandler interactorHandler, TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.interactorHandler = interactorHandler;
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    public void createTask(String name, String description, Callback<Task> callback) {
        this.name = name;
        this.description = description;
        this.callback = callback;
        interactorHandler.execute(this);
    }

    @Override public void run() {
        Task newTask = taskFromParameters();
        setupProjectAndList(newTask);
        saveNewTaskAndNotify(newTask);
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
        } else {
            //TODO throw exception
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
}
