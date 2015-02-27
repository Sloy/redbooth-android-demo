package com.sloydev.redbooth.interactor;

public interface Interactor extends Runnable {
    interface Callback<Result> {
        void onLoaded(Result result);
    }
}
