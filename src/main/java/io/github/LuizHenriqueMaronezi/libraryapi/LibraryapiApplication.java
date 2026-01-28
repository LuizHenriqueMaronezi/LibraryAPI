package io.github.LuizHenriqueMaronezi.libraryapi;

import io.github.LuizHenriqueMaronezi.libraryapi.model.Autor;
import io.github.LuizHenriqueMaronezi.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaAuditing
public class LibraryapiApplication {

	public static void main(String[] args) {

        SpringApplication.run(LibraryapiApplication.class, args);
	}

}
