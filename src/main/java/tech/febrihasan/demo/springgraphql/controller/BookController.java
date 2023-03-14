package tech.febrihasan.demo.springgraphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import tech.febrihasan.demo.springgraphql.model.Book;
import tech.febrihasan.demo.springgraphql.service.internal.AuthorService;
import tech.febrihasan.demo.springgraphql.service.internal.BookService;

/**
 * @author febrihasan
 */
@Controller
@RequiredArgsConstructor
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;

    /**
     * Mutation insert data book to repository
     *
     * @param book input data
     * @return data of book
     */
    @MutationMapping
    public Book addBook(@Argument BookInput book) {
        return bookService.save(new Book(null, book.title(), book.publisher(),
                authorService.getById(book.authorId())
                        .orElseThrow(IllegalArgumentException::new)));
    }

    /**
     * Constructor to bookInput
     *
     * @param title
     * @param publisher
     * @param authorId
     */
    record BookInput(String title, String publisher, Long authorId) {}

}
