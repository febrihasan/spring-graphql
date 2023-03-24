package tech.febrihasan.demo.springgraphql.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import tech.febrihasan.demo.springgraphql.model.Department;
import tech.febrihasan.demo.springgraphql.model.Employee;
import tech.febrihasan.demo.springgraphql.service.internal.EmployeeService;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    /**
     * Query all data of employees
     *
     * @return list of employees
     */
    @QueryMapping
    public List<Employee> employees() {
        return service.getAll();
    }

    @SchemaMapping(typeName = "Department", field = "employees")
    public List<Employee> allEmployees(Department department) {
        log.info("department Id: " + department.getId());
        return service.getAllEmployeeByDepartmentId(department.getId());
    }

    /**
     * Query one data of employee
     *
     * @param name is employee name
     * @return data employee
     */
    @QueryMapping
    public Optional<Employee> employeeByName(@Argument String name) {
        return service.getByName(name);
    }

    /**
     * Mutation insert data employee to repository
     *
     * @param employee input data
     * @return data of employee
     */
    @MutationMapping
    public Employee addEmployee(@Argument EmployeeInput employee) {
        return service.save(new Employee(null, employee.name(),
                employee.address(), employee.departmentId()));
    }

    /**
     * Mutation update data employee to repository
     *
     * @param employee update data
     * @return data of employee
     */
    @MutationMapping
    public Employee updateEmployee(@Argument EmployeeUpdate employee) {
        return service.update(new Employee(employee.id(), employee.name(),
                employee.address(), employee.departmentId()));
    }

    /**
     * Mutation delete data employee to repository
     *
     * @param id to delete data
     */
    @MutationMapping
    public Boolean deleteEmployee(@Argument Long id) {
        Optional<Employee> o = service.getById(id);
        if (o.isPresent()) {
            service.delete(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Constructor to bookInput
     *
     * @param name
     */
    record EmployeeInput(String name, String address, Long departmentId) {}
    record EmployeeUpdate(Long id, String name, String address, Long departmentId) {}

}
