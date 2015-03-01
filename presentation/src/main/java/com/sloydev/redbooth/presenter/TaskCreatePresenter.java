package com.sloydev.redbooth.presenter;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.interactor.CreateTaskInteractor;
import com.sloydev.redbooth.interactor.Interactor;
import com.sloydev.redbooth.view.TaskCreateView;

import javax.inject.Inject;

public class TaskCreatePresenter implements Presenter {

    private final CreateTaskInteractor createTaskInteractor;
    private TaskCreateView taskCreateView;

    @Inject public TaskCreatePresenter(CreateTaskInteractor createTaskInteractor) {
        this.createTaskInteractor = createTaskInteractor;
    }

    public void initialize(TaskCreateView taskCreateView) {
        this.taskCreateView = taskCreateView;
    }

    public void done() {
        String title = filterText(taskCreateView.getTaskTitle());
        String description = filterText(taskCreateView.getTaskDescription());
        Boolean urgent = taskCreateView.isTaskUrgent();
        createTaskInteractor.createTask(title, description, urgent, new Interactor.Callback<Task>() {
            @Override public void onLoaded(Task task) {
                taskCreated();
            }
        });

    }

    private String filterText(String input) {
        return input.trim();
    }

    private void taskCreated() {
        this.closeScreen();
    }

    private void closeScreen() {
        this.taskCreateView.close();
    }
}
