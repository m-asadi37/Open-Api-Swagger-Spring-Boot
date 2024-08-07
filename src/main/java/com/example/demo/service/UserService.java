package com.example.demo.service;

import com.example.demo.da.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public User update(User user) {
        User newUser = repository.save(user);
        return newUser;
    }

    @Transactional
    public void delete(User user) {
        repository.delete(user);
    }

    public User findBtId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        List<User> r = new ArrayList<>();
        repository.findAll().forEach(r::add);
        return r;
    }

    public List<User> findByNameLike(String name) {
        List<User> r = new ArrayList<>();
        repository.findByNameLikeIgnoreCase(name).forEach(r::add);
        return r;
    }
}
