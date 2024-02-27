package net.atos.acelera.todo.service;

import net.atos.acelera.todo.model.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getAllTasks();
    Task getTaskById(Long id);

    Task saveTask(Task task);

    void deleteTaskById(Long id);

    Task updateTask(Task task);

    List<Task> saveAllTasks(List<Task> tasks);

}
