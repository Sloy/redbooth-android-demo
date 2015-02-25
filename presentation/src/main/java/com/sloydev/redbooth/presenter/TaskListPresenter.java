package com.sloydev.redbooth.presenter;

import com.sloydev.redbooth.model.TaskModel;
import com.sloydev.redbooth.view.TaskListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TaskListPresenter implements Presenter {

    private TaskListView taskListView;

    @Inject public TaskListPresenter() {
    }

    public void initialize(TaskListView taskListView) {
        this.taskListView = taskListView;
        this.loadTasks();
    }

    private void loadTasks() {
        loadMockTasks();
    }

    private void loadMockTasks() {
        List<TaskModel> tasks = new ArrayList<>();
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        tasks.add(mockTask());
        onTaskListLoaded(tasks);
    }

    private void onTaskListLoaded(List<TaskModel> tasks) {
        taskListView.renderTaskList(tasks);
    }

    private TaskModel mockTask() {
        TaskModel taskModel = new TaskModel();
        taskModel.setTitle("Title");
        taskModel.setDescription("Description\nFor the task");
        return taskModel;
    }
}
