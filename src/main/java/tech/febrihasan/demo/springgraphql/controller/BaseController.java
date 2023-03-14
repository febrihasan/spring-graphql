package tech.febrihasan.demo.springgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.febrihasan.demo.springgraphql.model.Author;
import tech.febrihasan.demo.springgraphql.service.delegate.AuthorRepository;

import java.util.List;

/**
 * @author febrihasan
 */
@RestController
public class BaseController {

    @Autowired
    private AuthorRepository repository;
    @GetMapping
    public ResponseEntity<List<Author>> authors() {
        return ResponseEntity.ok(repository.findAll());
    }

}
