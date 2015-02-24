package com.sloydev.redbooth.interactor;

public interface InteractorHandler {
    void execute(Interactor interactor);

    void postResponse(Runnable responseRunnable);
}
