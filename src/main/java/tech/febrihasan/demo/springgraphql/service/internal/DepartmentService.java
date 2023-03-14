package tech.febrihasan.demo.springgraphql.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.febrihasan.demo.springgraphql.model.Department;
import tech.febrihasan.demo.springgraphql.service.delegate.DepartmentRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentRepository repository;

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Optional<Department> getById(Long id) {
        return repository.findById(id);
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    public Department update(Department department) {
        return repository.save(department);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
