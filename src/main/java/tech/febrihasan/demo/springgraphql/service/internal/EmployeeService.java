package tech.febrihasan.demo.springgraphql.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.febrihasan.demo.springgraphql.model.Book;
import tech.febrihasan.demo.springgraphql.model.Employee;
import tech.febrihasan.demo.springgraphql.service.delegate.BookRepository;
import tech.febrihasan.demo.springgraphql.service.delegate.EmployeeRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Employee> getByName(String name) {
        return repository.findByName(name);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

}
