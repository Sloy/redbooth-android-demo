package com.sloydev.redbooth;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

public class RedboothApplication extends Application{


    private ObjectGraph objectGraph;

    @Override public void onCreate() {
        super.onCreate();
        buildObjectGraph();

        setupDebuging();
    }

    private void setupDebuging() {
    }

    private void buildObjectGraph() {
        objectGraph = ObjectGraph.create(Modules.list(this));
    }

    public static RedboothApplication get(Context context) {
        return (RedboothApplication) context.getApplicationContext();
    }

    public void inject(Object target) {
        objectGraph.inject(target);
    }
}
