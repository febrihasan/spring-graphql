package tech.febrihasan.demo.springgraphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tech.febrihasan.demo.springgraphql.model.Employee;
import tech.febrihasan.demo.springgraphql.service.internal.EmployeeService;

import java.util.List;
import java.util.Optional;

/**
 * @author febrihasan
 */
@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Query all data of employees
     *
     * @return list of employees
     */
    @QueryMapping
    public List<Employee> employees() {
        return employeeService.getAll();
    }

    /**
     * Query one data of employee
     *
     * @param name is employee name
     * @return data employee
     */
    @QueryMapping
    public Optional<Employee> employeeByName(@Argument String name) {
        return employeeService.getByName(name);
    }

    /**
     * Mutation insert data employee to repository
     *
     * @param employee input data
     * @return data of employee
     */
    @MutationMapping
    public Employee addEmployee(@Argument EmployeeInput employee) {
        return employeeService.save(new Employee(null, employee.name(), employee.departmentId()));
    }

    /**
     * Constructor to bookInput
     *
     * @param name
     */
    record EmployeeInput(String name, Long departmentId) {}

}
