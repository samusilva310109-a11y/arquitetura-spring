package io.github.samuel.arquiteturaspring.todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return this.todoService.salvar(todo);
    }

    @GetMapping
    public List<TodoEntity> listarTodos(){
        return this.todoService.listarTodo();
    }

    @GetMapping("/{id}")
    public TodoEntity buscarTodo(@PathVariable Integer id){
        return this.todoService.buscarTodo(id);
    }

    @PutMapping("/{id}")
    public TodoEntity atualizarTodo(@PathVariable Integer id, TodoEntity todo){
        return this.todoService.atualizarTodo(id, todo);
    }
}
