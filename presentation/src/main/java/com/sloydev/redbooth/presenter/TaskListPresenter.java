package com.sloydev.redbooth.presenter;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.interactor.GetTaskListInteractor;
import com.sloydev.redbooth.interactor.Interactor;
import com.sloydev.redbooth.model.TaskModel;
import com.sloydev.redbooth.model.mapper.TaskModelMapper;
import com.sloydev.redbooth.view.TaskListView;

import java.util.List;

import javax.inject.Inject;

public class TaskListPresenter implements Presenter {

    private final GetTaskListInteractor getTaskListInteractor;
    private final TaskModelMapper taskModelMapper;

    private TaskListView taskListView;

    @Inject public TaskListPresenter(GetTaskListInteractor getTaskListInteractor, TaskModelMapper taskModelMapper) {
        this.getTaskListInteractor = getTaskListInteractor;
        this.taskModelMapper = taskModelMapper;
    }

    public void initialize(TaskListView taskListView) {
        this.taskListView = taskListView;
        this.loadTasks();
    }

    private void loadTasks() {
        getTaskListInteractor.loadTaskList(new Interactor.Callback<List<Task>>() {
            @Override public void onLoaded(List<Task> tasks) {
                onTaskListLoaded(taskModelMapper.transform(tasks));
            }
        });
    }

    private void onTaskListLoaded(List<TaskModel> tasks) {
        taskListView.renderTaskList(tasks);
    }

}
