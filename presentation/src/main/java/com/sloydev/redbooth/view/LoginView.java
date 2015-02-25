package com.sloydev.redbooth.view;

public interface LoginView {
    void showOAuthLoginForm(String url);

    void hideOAuthLoginForm();

    void navigateToTaskList();

}
