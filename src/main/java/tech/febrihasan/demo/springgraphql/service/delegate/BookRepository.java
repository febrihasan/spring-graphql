package tech.febrihasan.demo.springgraphql.service.delegate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.febrihasan.demo.springgraphql.model.Book;

/**
 * @author febrihasan
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
