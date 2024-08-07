package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.core.model.ApiDescription;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(produces = "application/json")
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public User update(@PathVariable ("id") Long id,  @RequestBody User user){
        return service.update(user.setId(id));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> delete(@PathVariable String id){
        long idL = Long.parseLong(id);
        service.delete(new User().setId(idL));
        if(service.findBtId(idL)!=null)
            return ResponseEntity.badRequest().body("delete nou successfully");
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping(produces = "application/json")
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User findById(@PathVariable String id){
        return service.findBtId(Long.parseLong(id));
    }

    @GetMapping(value = "/", produces = "application/json")
    public @ApiResponse List<User> findByNameLike(@RequestParam String name){
        return service.findByNameLike(name);
    }

}
