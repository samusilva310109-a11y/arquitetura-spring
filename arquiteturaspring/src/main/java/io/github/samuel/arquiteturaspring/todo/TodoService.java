package io.github.samuel.arquiteturaspring.todo;

import io.github.samuel.arquiteturaspring.todo.utils.TodoValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final TodoValidator validator;

    public TodoService(TodoRepository todoRepository, TodoValidator validator){
        this.repository = todoRepository;
        this.validator = validator;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        try{
            this.validator.validar(novoTodo);
            return this.repository.save(novoTodo);
        } catch (IllegalArgumentException e) {
            String messageError = e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, messageError);
        }
    }

    public List<TodoEntity> listarTodo(){
        return this.repository.findAll();
    }

    public TodoEntity buscarTodo(Integer id){
        return  this.repository.findById(id).orElse(null);
    }

    public TodoEntity atualizarTodo(Integer id, TodoEntity todo){
        try {
            this.validator.validar(todo);
            todo.setId(id);
            return this.repository.save(todo);
        }catch (IllegalArgumentException e){
            String message = e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
    }
}
