package io.github.samuel.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    @Value("${app.config.variavel}") //Injeta o valor da variavel presente
                                                    // no application.yml na variável
    private String variavel;

    public void imprimir() {
        System.out.println(variavel);
    }
}
