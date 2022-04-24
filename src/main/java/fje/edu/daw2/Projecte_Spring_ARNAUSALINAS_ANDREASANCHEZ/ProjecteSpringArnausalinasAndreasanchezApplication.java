package fje.edu.daw2.Projecte_Spring_ARNAUSALINAS_ANDREASANCHEZ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MongoDBRepositori.class)
public class ProjecteSpringArnausalinasAndreasanchezApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecteSpringArnausalinasAndreasanchezApplication.class, args);

	}

}
