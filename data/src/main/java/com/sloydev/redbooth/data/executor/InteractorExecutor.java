package com.sloydev.redbooth.data.executor;

import android.os.Handler;
import android.os.Looper;

import com.sloydev.redbooth.interactor.Interactor;
import com.sloydev.redbooth.interactor.InteractorHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Decorated {@link java.util.concurrent.ThreadPoolExecutor} Singleton class based on
 * 'Initialization on Demand Holder' pattern.
 */
public class InteractorExecutor implements InteractorHandler {

    private final Handler responseHandler;

    @Override public void execute(Interactor interactor) {
        if (interactor == null) {
            throw new IllegalArgumentException("Interactor to execute cannot be null");
        }
        this.threadPoolExecutor.execute(interactor);
    }

    @Override public void postResponse(Runnable responseRunnable) {
        responseHandler.post(responseRunnable);
    }

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;

    // Sets the amount of time an idle thread waits before terminating
    private static final int KEEP_ALIVE_TIME = 10;

    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> workQueue;

    private final ThreadPoolExecutor threadPoolExecutor;

    private final ThreadFactory threadFactory;

    @Inject public InteractorExecutor() {
        this.responseHandler = new Handler(Looper.getMainLooper());

        this.workQueue = new LinkedBlockingQueue<>();
        this.threadFactory = new JobThreadFactory();
        this.threadPoolExecutor = new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME = "android_";
        private int counter = 0;

        @Override public Thread newThread(Runnable runnable) {
            return new Thread(runnable, THREAD_NAME + counter);
        }
    }
}