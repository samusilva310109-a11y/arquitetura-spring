package io.github.samuel.arquiteturaspring.todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    public boolean existsByDescricao(String descricao);
}
