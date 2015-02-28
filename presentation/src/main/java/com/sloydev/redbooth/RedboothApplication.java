package com.sloydev.redbooth;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import dagger.ObjectGraph;

public class RedboothApplication extends Application{


    private ObjectGraph objectGraph;

    @Override public void onCreate() {
        super.onCreate();
        buildObjectGraph();

        setupDebuging();
    }

    private void setupDebuging() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
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
