package com.sloydev.redbooth.view;

public interface TaskCreateView {
    void close();

    String getTaskTitle();

    String getTaskDescription();

    Boolean isTaskUrgent();

    void showError(String errorMessage);
}
