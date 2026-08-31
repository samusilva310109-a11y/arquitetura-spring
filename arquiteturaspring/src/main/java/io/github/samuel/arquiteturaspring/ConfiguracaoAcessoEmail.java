package io.github.samuel.arquiteturaspring;

import io.github.samuel.arquiteturaspring.todo.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoAcessoEmail {

    @Autowired
    AppProperties appProperties;

    @Bean
    public MailSender mailSender() {
        return null;
    }
}
