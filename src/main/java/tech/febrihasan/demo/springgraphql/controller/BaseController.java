package tech.febrihasan.demo.springgraphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.febrihasan.demo.springgraphql.model.Author;
import tech.febrihasan.demo.springgraphql.model.Book;
import tech.febrihasan.demo.springgraphql.model.Department;
import tech.febrihasan.demo.springgraphql.model.Employee;
import tech.febrihasan.demo.springgraphql.service.internal.AuthorService;
import tech.febrihasan.demo.springgraphql.service.internal.BookService;
import tech.febrihasan.demo.springgraphql.service.internal.DepartmentService;
import tech.febrihasan.demo.springgraphql.service.internal.EmployeeService;

import java.util.List;

/**
 * @author febrihasan
 */
@RestController
@RequiredArgsConstructor
public class BaseController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping("/authors")
    public List<Author> authors() {
        return authorService.getAll();
    }

    @GetMapping("/books")
    public List<Book> books() {
        return bookService.getAll();
    }

    @GetMapping("/departments")
    public List<Department> departments() {
        return departmentService.getAll();
    }

    @GetMapping("/employees")
    public List<Employee> employees() {
        return employeeService.getAll();
    }

}
