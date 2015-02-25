package com.sloydev.redbooth.view.activity;

import com.sloydev.redbooth.R;

import butterknife.ButterKnife;

public class TaskListActivity extends BaseToolbarActivity {

    @Override protected int getLayoutResource() {
        return R.layout.activity_task_list;
    }

    @Override protected void initializeViews() {
        ButterKnife.inject(this);
    }

    @Override protected void initializePresenter() {

    }
}
