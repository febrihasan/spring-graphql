package tech.febrihasan.demo.springgraphql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.febrihasan.demo.springgraphql.model.Author;
import tech.febrihasan.demo.springgraphql.model.Book;
import tech.febrihasan.demo.springgraphql.service.delegate.AuthorRepository;
import tech.febrihasan.demo.springgraphql.service.delegate.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlApplication.class, args);
	}

	/**
	 * Generate data entity during startup application running
	 *
	 * @param authorRepository
	 * @param bookRepository
	 *
	 * @return application runner of repository
	 */
	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author febri = authorRepository.save(new Author(null, "Febri", new ArrayList<>()));
			log.info("[data-1] => id: " + febri.getId() + ", name: " + febri.getName());
			Author hasan = authorRepository.save(new Author(null, "Hasan", new ArrayList<>()));
			log.info("[data-2] => id: " + hasan.getId() + ", name: " + hasan.getName());
			Author basri = authorRepository.save(new Author(null, "Basri", new ArrayList<>()));
			log.info("[data-3] => id: " + basri.getId() + ", name: " + basri.getName());
			List<Book> books = bookRepository.saveAll(List.of(
					new Book(null, "Spring Reactive", "Akar Inti Tekno", febri),
					new Book(null, "Java Reflection", "Akar Inti Tekno", hasan),
					new Book(null, "Spring GraphQL", "Akar Inti Tekno", basri)
			));

			books.stream().forEach(s ->
					System.out.println("[books] => id: " + s.getId() + ", title: " + s.getTitle()));
		};
	}

}
