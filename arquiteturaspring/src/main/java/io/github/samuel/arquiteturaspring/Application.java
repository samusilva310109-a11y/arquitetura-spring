package io.github.samuel.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties //Habilita a utilização de classes de Configuration Properties
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder =
				new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF); // <- Desabilita o Banner Spring
		SpringApplicationBuilder perfilName = builder.profiles("producao", "homologacao");
		builder.properties("server.port=3030"); // <- define a porta da aplicação

		builder.run(args); // <- Inicializa o projeto spring
		builder.lazyInitialization(true); // <- Determina o comportamento Lazy para todos os Beans



		// Contexto da aplicação já iniciada:
		ApplicationContext applicationContext = builder.context();


        assert applicationContext != null;
        Environment environment =
				applicationContext.getEnvironment();

		// applicationContext.getBean("ProdutoRepository"); // <- Captura uma Bean pelo nome

		String applicationName =
				environment.getProperty("spring.application.name"); // <- Captura o valor da propiedade


		ExemploValue ex = applicationContext.getBean(ExemploValue.class);

		ex.imprimir();

		AppProperties appProperties = applicationContext.getBean(AppProperties.class);
		System.out.println(appProperties.getValor1());
//		System.out.println(applicationName);
//		System.out.println("Nome do perfil: " + perfilName);

	}

}
