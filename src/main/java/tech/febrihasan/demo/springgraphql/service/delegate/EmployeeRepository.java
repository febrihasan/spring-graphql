package tech.febrihasan.demo.springgraphql.service.delegate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.febrihasan.demo.springgraphql.model.Employee;

import java.util.Optional;

/**
 * @author febrihasan
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByName(String name);



}