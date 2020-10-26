/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package net.lyncas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"net.lyncas.api",
		"net.lyncas.usecase.services",
		"net.lyncas.persistence.adapter"
})
@EntityScan(basePackages = {
		"net.lyncas.persistence.entities"
})
@EnableJpaRepositories(basePackages = {
		"net.lyncas.persistence.repositories"
})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
