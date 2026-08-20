package io.github.samuel.arquiteturaspring.todo.utils;

import io.github.samuel.arquiteturaspring.todo.TodoEntity;
import io.github.samuel.arquiteturaspring.todo.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if (existeDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("[ERROR] Esta descrição já existe");
        }
    }

    public boolean existeDescricao(String descricao){
        return repository.existsByDescricao(descricao);
    }
}
