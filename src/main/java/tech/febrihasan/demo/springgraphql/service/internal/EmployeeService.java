package tech.febrihasan.demo.springgraphql.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.febrihasan.demo.springgraphql.model.Author;
import tech.febrihasan.demo.springgraphql.model.Department;
import tech.febrihasan.demo.springgraphql.model.Employee;
import tech.febrihasan.demo.springgraphql.service.delegate.EmployeeRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Service
@RequiredArgsConstructor
@Transactional
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

    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
