package com.udemy.rest.webservicescourse.user;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

  @Autowired
  private UserRepository repository;

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return repository.findAll();
  }

//  @GetMapping("/users/{id}")
//  public EntityModel<User> retrieveUsers(@PathVariable Integer id) {
//    User user = repository.findById(id);
//    // hateoas for all users
//    EntityModel<User> model = new EntityModel<>(user);
//    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
//        .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
//    model.add(linkTo.withRel("all-users"));
//    return model;
//  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> retrieveUsers(@PathVariable Integer id) {
    User user = repository.findById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User newUser = repository.createUser(user);
    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(user.getId())
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Integer id) {
    User user = repository.deleteById(id);
  }

}
