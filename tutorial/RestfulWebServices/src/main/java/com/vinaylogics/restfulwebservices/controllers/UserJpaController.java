package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.daos.UserDaoService;
import com.vinaylogics.restfulwebservices.daos.UserService;
import com.vinaylogics.restfulwebservices.models.Post;
import com.vinaylogics.restfulwebservices.models.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa/users")
public class UserJpaController {

    private final UserDaoService daoService;
    private final UserService service;


    public UserJpaController(UserDaoService daoService, UserService service) {
        this.daoService = daoService;
        this.service = service;
    }

    // GET /users
    // retrieveAllUsers
    @GetMapping("/")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // GET /users/{id}
    //retrieveUser(int id)
    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        EntityModel<User> model = EntityModel.of(service.findById(id));
        WebMvcLinkBuilder linkToUsers =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    //
    // input - details of user
    // output - CREATED & Return the URI
    @PostMapping("/")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        // CREATED
        // /user/{id} savedUser.getId()
       URI location = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedUser.getId())
               .toUri();
       return ResponseEntity.created(location).build();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int userId){
        service.deleteById(userId);
    }

    // POST for Users
    @GetMapping("/{id}/posts")
    public List<Post> retrieveUserAllPost(@PathVariable int id){
        User user = service.findById(id);
        return user.getPosts();
    }
}
