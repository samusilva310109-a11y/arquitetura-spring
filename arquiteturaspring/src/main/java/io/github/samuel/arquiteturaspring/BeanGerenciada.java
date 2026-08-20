package io.github.samuel.arquiteturaspring;

import io.github.samuel.arquiteturaspring.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy(false) //<- Desativa o comportamento Lazy (o padrão da anotação é true)
@Scope("singleton")
//@Scope("request") ->  Cria uma instância unica para cada requisição finalizando seu ciclo de vida, após a requisição
//@Scope("session") ->  Cria uma instância unica para durar  toda a sessão do usuário
//@Scope("application") -> cria uma instância para uma aplicação inteira
//@Scope("prototype") -> cria uma instância para cada usuário
public class BeanGerenciada {

    /*
     *  A injeção de dependência pode ocorrer das segunites formas:
     *
     *   1. Excrevendo a anotação @Autorwired acima da propria variável
     *   2. Injetando a dependência através de um construtor (o uso da annotation @Autowired não é obrigatória)
     *   3. Injetando através de um método Setter (o uso da annotation @Autowired é obirgatório neste caso)
     *
     * */

    //1. forma (não denota opcionalidade ou obrigatoriedade) (menos recomendado)
    @Autowired
    private TodoService service; //-> Injeção via propriedade

    //2. forma (denota obrigatoriedade)
    public BeanGerenciada(TodoService service) {
        this.service = service;
    } //<- Injeção via construtor

    //3. forma (denota opcionalidade)
    @Autowired
    public void setService(TodoService service) {
        this.service = service;
    } // <-Injeção via método
}
