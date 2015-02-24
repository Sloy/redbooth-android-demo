package com.sloydev.redbooth.interactor;

public class DummyInteractor implements Interactor {

    private final InteractorHandler interactorHandler;
    private Callback callback;

    public DummyInteractor(InteractorHandler interactorHandler) {
        this.interactorHandler = interactorHandler;
    }

    public void loadDummy(Callback callback) {
        this.callback = callback;
        interactorHandler.execute(this);
    }

    @Override public void run() {
        final String response = "Yo me llamo Ralph";
        interactorHandler.postResponse(new Runnable() {
            @Override public void run() {
                callback.onLoaded(response);
            }
        });

    }

    static interface Callback {
        void onLoaded(String response);
    }
}
