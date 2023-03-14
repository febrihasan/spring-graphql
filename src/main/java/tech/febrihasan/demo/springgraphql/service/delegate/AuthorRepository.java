package tech.febrihasan.demo.springgraphql.service.delegate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.febrihasan.demo.springgraphql.model.Author;

/**
 * @author febrihasan
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
