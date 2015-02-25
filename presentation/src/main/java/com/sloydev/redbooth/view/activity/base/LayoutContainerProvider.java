package com.sloydev.redbooth.view.activity.base;

import android.app.Activity;
import android.view.ViewGroup;

import static butterknife.ButterKnife.findById;

public interface LayoutContainerProvider {

    public ViewGroup get(Activity activity);

    LayoutContainerProvider DEFAULT = new LayoutContainerProvider() {
        @Override public ViewGroup get(Activity activity) {
            return findById(activity, android.R.id.content);
        }
    };
}
