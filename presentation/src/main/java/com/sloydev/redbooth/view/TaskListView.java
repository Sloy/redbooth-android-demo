package com.sloydev.redbooth.view;

import com.sloydev.redbooth.model.TaskModel;
import java.util.List;

public interface TaskListView {

    void renderTaskList(List<TaskModel> tasks);
}
