package tech.febrihasan.demo.springgraphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tech.febrihasan.demo.springgraphql.model.Author;
import tech.febrihasan.demo.springgraphql.service.internal.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    /**
     * Query all data of authors
     *
     * @return list of authors
     */
    @QueryMapping
    public List<Author> authors() {
        return service.getAll();
    }

    /**
     * Query one data of author
     *
     * @param id is author id
     * @return data author
     */
    @QueryMapping
    public Optional<Author> authorById(@Argument Long id) {
        return service.getById(id);
    }

    /**
     * Mutation insert data author to repository
     *
     * @param author input data
     * @return data of author
     */
    @MutationMapping
    public Author addAuthor(@Argument AuthorInput author) {
        return service.save(new Author(null, author.name(), new ArrayList<>()));
    }

    /**
     * Mutation update data author to repository
     *
     * @param author update data
     * @return data of author
     */
    @MutationMapping
    public Author updateAuthor(@Argument AuthorUpdate author) {
        return service.update(new Author(author.id(), author.name(), new ArrayList<>()));
    }

    /**
     * Mutation delete data author to repository
     *
     * @param id to delete data
     */
    @MutationMapping
    public Boolean deleteAuthor(@Argument Long id) {
        Optional<Author> o = service.getById(id);
        if (o.isPresent()) {
            service.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Constructor to authorInput
     *
     * @param name
     */
    record AuthorInput(String name) {}
    record AuthorUpdate(Long id, String name) {}

}
