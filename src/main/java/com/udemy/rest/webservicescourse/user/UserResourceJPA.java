package com.udemy.rest.webservicescourse.user;

import com.udemy.rest.webservicescourse.post.Post;
import com.udemy.rest.webservicescourse.post.PostRepository;
import com.udemy.rest.webservicescourse.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

// import org.springframework.hateoas.EntityModel;
// import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@RestController
public class UserResourceJPA {

  @Autowired private UserDAOAccess repository;
  @Autowired private UserRepository userRepository;
  @Autowired private PostRepository postRepository;

  @GetMapping("/jpa/users")
  public List<User> retrieveAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public ResponseEntity<User> retrieveUser(@PathVariable Integer id) {
    Optional<User> user = userRepository.findById(id);
    if (!user.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }
    return ResponseEntity.ok(user.get());
  }

  @GetMapping("/jpa/users/{id}/posts")
  public ResponseEntity<List<Post>> retrievePosts(@PathVariable Integer id) {
    Optional<User> user = userRepository.findById(id);
    if (!user.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }
    return ResponseEntity.ok(user.get().getPosts());
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Post> createPosts(@PathVariable Integer id, @RequestBody Post post) {
    Optional<User> userOptional = userRepository.findById(id);
    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }
    User user = userOptional.get();
    post.setUser(user);
    postRepository.save(post);
    URI location =
            ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(post.getId())
                    .toUri();
    return ResponseEntity.created(location).build();
  }

  @PostMapping("/jpa/users/{id}/post")
  public ResponseEntity<Object> createPost(@Valid @RequestBody User user) {
    User newUser = userRepository.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable Integer id) {
    userRepository.deleteById(id);
  }
}
