package net.atos.acelera.todo.controller;

import net.atos.acelera.todo.model.Task;
import net.atos.acelera.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {
        private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    //Autowired

    //GetMapping
    @GetMapping("/create")
    public String createTask(){
        return "create";
    }

    //GetMapping com id

    //PostMapping
    @PostMapping("/create")
    public String createTask(Task task){
        if (null != task.getId()){
            Task foundTask = taskService.getTaskById(task.getId());
            foundTask.setTitle(task.getTitle());
            foundTask.setDescription(task.getDescription());
            foundTask.setDueDate(task.getDueDate());
            task = foundTask;
        }

        taskService.saveTask(task);
        System.out.println("Task created successfully: " + task.getTitle());
        return "redirect:/list";
    }

    //GetMapping list
    @GetMapping("/list")
    public ModelAndView list(){

        ModelAndView mv = new ModelAndView("list", "tasks", taskService.getAllTasks());
        return mv;
    }

    //GetMapping edit
    @GetMapping("/edit/{id}")
    public ModelAndView  edit (@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("create");

        Task foundTask = taskService.getTaskById(id);
        mv.addObject("task", foundTask);

        return mv;
    }

    //PutMapping

    //Deletemapping
}
