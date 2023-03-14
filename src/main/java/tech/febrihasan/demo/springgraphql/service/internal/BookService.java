package tech.febrihasan.demo.springgraphql.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.febrihasan.demo.springgraphql.model.Book;
import tech.febrihasan.demo.springgraphql.service.delegate.BookRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BookService {

    private final BookRepository repository;

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return repository.findById(id);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public Book update(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
