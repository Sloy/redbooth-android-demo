package com.sloydev.redbooth.view.activity;

import com.sloydev.redbooth.R;

import butterknife.ButterKnife;


public class MainActivity extends BaseToolbarActivity {

    @Override protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override protected void initializeViews() {
        ButterKnife.inject(this);
    }

    @Override protected void created() {

    }
}
