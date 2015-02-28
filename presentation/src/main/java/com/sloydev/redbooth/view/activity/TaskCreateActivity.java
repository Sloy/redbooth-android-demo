package com.sloydev.redbooth.view.activity;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.sloydev.redbooth.R;
import com.sloydev.redbooth.view.activity.base.BaseToolbarActivity;

import butterknife.ButterKnife;

public class TaskCreateActivity extends BaseToolbarActivity {

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
        //TODO
    }

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
                //TODO notify presenter
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
