package com.sloydev.redbooth.view.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.InjectView;

import com.melnykov.fab.FloatingActionButton;
import com.sloydev.redbooth.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

import com.sloydev.redbooth.model.TaskModel;
import com.sloydev.redbooth.presenter.TaskListPresenter;
import com.sloydev.redbooth.view.TaskListView;
import com.sloydev.redbooth.view.activity.base.BaseToolbarActivity;
import com.sloydev.redbooth.view.adapter.CardTaskListAdapter;

import java.util.List;
import javax.inject.Inject;

public class TaskListActivity extends BaseToolbarActivity implements TaskListView {

    private static final int REQUEST_CREATE_TASK = 1;

    @Inject TaskListPresenter presenter;

    @InjectView(R.id.tasks_list) RecyclerView taskListView;
    @InjectView(R.id.new_task) FloatingActionButton newTaskButton;

    private CardTaskListAdapter adapter;

    @Override protected int getLayoutResource() {
        return R.layout.activity_task_list;
    }

    @Override protected void initializeViews() {
        ButterKnife.inject(this);
        taskListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CardTaskListAdapter();
        taskListView.setAdapter(adapter);
        newTaskButton.attachToRecyclerView(taskListView);
    }

    @Override protected void initializePresenter() {
        presenter.initialize(this);
    }

    @Override protected void setupActionBar(ActionBar actionBar) {
        /* no-op */
    }

    @OnClick(R.id.new_task)
    public void onNewTaskClick() {
        startActivityForResult(new Intent(this, TaskCreateActivity.class), REQUEST_CREATE_TASK);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CREATE_TASK && resultCode == RESULT_OK) {
            presenter.taskCreated();
        }
    }

    @Override public void renderTaskList(List<TaskModel> tasks) {
        adapter.setTasks(tasks);
    }


}
