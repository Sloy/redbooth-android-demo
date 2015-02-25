package com.sloydev.redbooth.view.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;

import com.sloydev.redbooth.RedboothApplication;

import javax.inject.Inject;

public abstract class BaseActivity extends ActionBarActivity {

    @Inject LayoutContainerProvider layoutContainerProvider;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        inflateLayout();
        initializeViews();
        initializePresenter();
    }

    protected void inflateLayout() {
        getLayoutInflater().inflate(getLayoutResource(), getRootViewContainer());
    }

    protected void injectDependencies() {
        RedboothApplication.get(this).inject(this);
    }

    protected ViewGroup getRootViewContainer() {
        return layoutContainerProvider.get(this);
    }

    protected abstract int getLayoutResource();

    protected abstract void initializeViews();

    protected abstract void initializePresenter();
}
