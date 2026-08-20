package io.github.samuel.arquiteturaspring;
import io.github.samuel.arquiteturaspring.todo.TodoEntity;
import io.github.samuel.arquiteturaspring.todo.TodoRepository;
import io.github.samuel.arquiteturaspring.todo.TodoService;
import io.github.samuel.arquiteturaspring.todo.utils.TodoValidator;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ExemploInjecaoDeDependencia {
    public static void main(String[] args) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/arquiteturaspring");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");

        /*
        * Exemplos ficticíos acima
        */

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository todoRepository = null; //new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator todoValidator = new TodoValidator(todoRepository);

        TodoService service = new TodoService(todoRepository, todoValidator);

    }
}
