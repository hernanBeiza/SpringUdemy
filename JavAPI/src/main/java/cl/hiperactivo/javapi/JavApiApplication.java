package cl.hiperactivo.javapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "cl.hiperactivo.javapi.Controllers")
@EnableJpaRepositories(basePackages = "cl.hiperactivo.javapi")
@EntityScan(basePackages = "cl.hiperactivo.javapi")
@EnableJpaAuditing
public class JavApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavApiApplication.class, args);

	}
}
