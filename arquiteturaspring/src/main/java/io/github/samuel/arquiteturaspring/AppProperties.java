package io.github.samuel.arquiteturaspring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.config") //Mapeia as propriedades com este prefixo e cria uma classe que contenha atributos com estes valores
public class AppProperties {
    String variavel; // Atributo criado com valores  de app.config.variavel
    Integer valor1; // Atributo criado com valores de app.config.valor1

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public Integer getValor1() {
        return valor1;
    }

    public void setValor1(Integer valor1) {
        this.valor1 = valor1;
    }
}
