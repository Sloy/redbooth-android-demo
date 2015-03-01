package com.sloydev.redbooth.interactor;

import com.sloydev.redbooth.exception.RedboothException;

public interface Interactor extends Runnable {
    interface Callback<Result> {
        void onLoaded(Result result);
    }

    interface ErrorCallback {
        void onError(RedboothException error);
    }
}
