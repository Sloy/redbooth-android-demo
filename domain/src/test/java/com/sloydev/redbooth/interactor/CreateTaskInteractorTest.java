package com.sloydev.redbooth.interactor;

import com.sloydev.redbooth.Task;
import com.sloydev.redbooth.TaskList;
import com.sloydev.redbooth.TestInteractorHandler;
import com.sloydev.redbooth.repository.TaskListRepository;
import com.sloydev.redbooth.repository.TaskRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateTaskInteractorTest {

    private static final String NAME_STUB = "name";
    private static final String DESCRIPTION_STUB = "description";
    private static final Long TASK_LIST_1 = 1L;
    private static final Long TASK_LIST_2 = 2L;
    private static final Long PROJECT_ID = 3L;

    @Mock TaskRepository taskRepository;
    @Mock TaskListRepository taskListRepository;
    @Mock Interactor.Callback<Task> callback;
    private InteractorHandler interactorHandler;

    private CreateTaskInteractor interactor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        interactorHandler = new TestInteractorHandler();
        interactor = new CreateTaskInteractor(interactorHandler, taskRepository, taskListRepository);
    }

    @Test
    public void shouldGetTaskListsBeforeCreating() throws Exception {
        InOrder order = inOrder(taskRepository, taskListRepository);

        interactor.createTask(NAME_STUB, DESCRIPTION_STUB, callback);

        order.verify(taskListRepository).getAll();
        order.verify(taskRepository).put(any(Task.class));
    }

    @Test
    public void shouldCreateTaskWithProjectIdAndListIdFromFirstTaskList() throws Exception {
        when(taskListRepository.getAll()).thenReturn(taskLists());

        interactor.createTask(NAME_STUB, DESCRIPTION_STUB, callback);
        ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository, times(1)).put(taskArgumentCaptor.capture());
        Task createdTask = taskArgumentCaptor.getValue();

        assertThat(createdTask.getProjectId()).isEqualTo(PROJECT_ID);
        assertThat(createdTask.getTaskListId()).isEqualTo(TASK_LIST_1);
    }


    private List<TaskList> taskLists() {
        List<TaskList> taskLists = new ArrayList<>();
        taskLists.add(taskList(TASK_LIST_1));
        taskLists.add(taskList(TASK_LIST_2));
        return taskLists;
    }

    private TaskList taskList(Long listId) {
        TaskList taskList = new TaskList();
        taskList.setId(listId);
        taskList.setProjectId(PROJECT_ID);
        return taskList;
    }

}