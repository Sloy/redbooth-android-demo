package com.sloydev.redbooth.view.activity;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.sloydev.redbooth.R;
import com.sloydev.redbooth.presenter.TaskCreatePresenter;
import com.sloydev.redbooth.view.TaskCreateView;
import com.sloydev.redbooth.view.activity.base.BaseToolbarActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TaskCreateActivity extends BaseToolbarActivity implements TaskCreateView {

    @InjectView(R.id.task_title) EditText titleText;
    @InjectView(R.id.task_description) EditText descriptionText;

    @Inject TaskCreatePresenter presenter;

    //region Initialization
    @Override protected void setupActionBar(ActionBar actionBar) {
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override protected int getLayoutResource() {
        return R.layout.activity_task_create;
    }

    @Override protected void initializeViews() {
        ButterKnife.inject(this);
    }

    @Override protected void initializePresenter() {
        presenter.initialize(this);
    }
    //endregion

    //region Activity methods
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_task_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_done:
                presenter.done();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //endregion

    //region View methods
    @Override public void close() {
        setResult(RESULT_OK);
        finish();
    }

    @Override public String getTaskTitle() {
        return titleText.getText().toString();
    }

    @Override public String getTaskDescription() {
        return descriptionText.getText().toString();
    }
    //endregion
}
