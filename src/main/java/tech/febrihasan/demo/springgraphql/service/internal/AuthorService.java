package tech.febrihasan.demo.springgraphql.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.febrihasan.demo.springgraphql.model.Author;
import tech.febrihasan.demo.springgraphql.service.delegate.AuthorRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Service
@RequiredArgsConstructor
@Transactional
public class AuthorService {

    private final AuthorRepository repository;

    public List<Author> getAll() {
        return repository.findAll();
    }

    public Optional<Author> getById(Long id) {
        return repository.findById(id);
    }

    public Author save(Author author) {
        return repository.save(author);
    }

    public Author update(Author author) {
        return repository.save(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
