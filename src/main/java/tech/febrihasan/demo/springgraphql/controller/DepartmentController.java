package tech.febrihasan.demo.springgraphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import tech.febrihasan.demo.springgraphql.model.Department;
import tech.febrihasan.demo.springgraphql.service.internal.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    /**
     * Query all data of departments
     *
     * @return list of departments
     */
    @QueryMapping
    public List<Department> departments() {
        return service.getAll();
    }

    /**
     * Query one data of department
     *
     * @param id is department id
     * @return data department
     */
    @QueryMapping
    public Optional<Department> departmentById(@Argument Long id) {
        return service.getById(id);
    }

    /**
     * Mutation insert data department to repository
     *
     * @param department input data
     * @return data of department
     */
    @MutationMapping
    public Department addDepartment(@Argument DepartmentInput department) {
        return service.save(new Department(null, department.name(), new ArrayList<>()));
    }

    /**
     * Mutation update data department to repository
     *
     * @param department update data
     * @return data of department
     */
    @MutationMapping
    public Department updateDepartment(@Argument DepartmentUpdate department) {
        return service.update(new Department(department.id(), department.name(), new ArrayList<>()));
    }

    /**
     * Mutation delete data department to repository
     *
     * @param id to delete data
     */
    @MutationMapping
    public Boolean deleteDepartment(@Argument Long id) {
        Optional<Department> o = service.getById(id);
        if (o.isPresent()) {
            service.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Constructor to departmentInput
     *
     * @param name
     */
    record DepartmentInput(String name) {}
    record DepartmentUpdate(Long id, String name) {}

}
