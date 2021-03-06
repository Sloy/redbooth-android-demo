package com.sloydev.redbooth.view.activity.base;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.sloydev.redbooth.R;

public abstract class BaseToolbarActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override protected ViewGroup getRootViewContainer() {
        ViewGroup toolbarDecorator = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_toolbar_decorator, super.getRootViewContainer());
        bindToolbar();
        return (ViewGroup) toolbarDecorator.findViewById(R.id.content);
    }

    private void bindToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            setupActionBar(getSupportActionBar());
        } else {
            throw new IllegalStateException("Toolbar view (R.id.toolbar_actionbar) not found in BaseToolbarActivity");
        }
    }

    protected abstract void setupActionBar(ActionBar actionBar);

    public Toolbar getToolbar() {
        return toolbar;
    }
}
