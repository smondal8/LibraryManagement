package io.soumyadev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import io.soumyadev.Repository.ILibraryManagementRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ILibraryManagementRepository.class)
@EntityScan("io.soumyadev.*")
public class LibraryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
