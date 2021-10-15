package com.vinaylogics.restfulwebservices.controllers;

import com.vinaylogics.restfulwebservices.daos.UserDaoService;
import com.vinaylogics.restfulwebservices.models.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService daoService;


    public UserController(UserDaoService daoService) {
        this.daoService = daoService;
    }

    // GET /users
    // retrieveAllUsers
    @GetMapping("/")
    public List<User> retrieveAllUsers(){
        return daoService.findAll();
    }

    // GET /users/{id}
    //retrieveUser(int id)
    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        EntityModel<User> model = EntityModel.of(daoService.findOne(id));
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
        User savedUser = daoService.save(user);
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
        daoService.deleteById(userId);
    }
}
