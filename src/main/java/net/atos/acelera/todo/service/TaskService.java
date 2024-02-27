package net.atos.acelera.todo.service;

import net.atos.acelera.todo.model.Task;
import net.atos.acelera.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TaskService implements ITaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) this.taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return this.taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task saveTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Task updateTask(Task task) {
        Task foundTask = this.taskRepository.findById(task.getId()).orElse(null);
        return this.taskRepository.save(foundTask);
    }

    @Override
    public List<Task> saveAllTasks(List<Task> tasks) {
        return (List<Task>) this.taskRepository.saveAll(tasks);
    }
}
