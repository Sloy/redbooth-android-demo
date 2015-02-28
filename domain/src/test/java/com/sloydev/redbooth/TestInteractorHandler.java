package com.sloydev.redbooth;

import com.sloydev.redbooth.interactor.Interactor;
import com.sloydev.redbooth.interactor.InteractorHandler;

public class TestInteractorHandler implements InteractorHandler {
    @Override public void execute(Interactor interactor) {
        interactor.run();
    }

    @Override public void postResponse(Runnable responseRunnable) {
        responseRunnable.run();
    }
}
