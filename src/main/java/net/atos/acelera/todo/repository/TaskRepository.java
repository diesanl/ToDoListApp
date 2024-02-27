package net.atos.acelera.todo.repository;

import net.atos.acelera.todo.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TaskRepository extends CrudRepository<Task, Long> {


    //Autowired

    //GetMapping

    //GetMapping com id

    //PostMapping

    //PutMapping

    //Deletemapping
}
