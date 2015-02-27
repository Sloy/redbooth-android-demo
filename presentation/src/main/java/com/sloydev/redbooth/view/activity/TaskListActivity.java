package com.sloydev.redbooth.view.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.InjectView;
import com.sloydev.redbooth.R;

import butterknife.ButterKnife;
import com.sloydev.redbooth.model.TaskModel;
import com.sloydev.redbooth.presenter.TaskListPresenter;
import com.sloydev.redbooth.view.TaskListView;
import com.sloydev.redbooth.view.activity.base.BaseToolbarActivity;
import com.sloydev.redbooth.view.adapter.CardTaskListAdapter;

import java.util.List;
import javax.inject.Inject;

public class TaskListActivity extends BaseToolbarActivity implements TaskListView {

    @Inject TaskListPresenter presenter;

    @InjectView(R.id.tasks_list) RecyclerView recyclerView;

    private CardTaskListAdapter adapter;

    @Override protected int getLayoutResource() {
        return R.layout.activity_task_list;
    }

    @Override protected void initializeViews() {
        ButterKnife.inject(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CardTaskListAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override protected void initializePresenter() {
        presenter.initialize(this);
    }

    @Override public void renderTaskList(List<TaskModel> tasks) {
        adapter.setTasks(tasks);
    }

    @Override protected void setupActionBar(ActionBar actionBar) {
        /* no-op */
    }
}
