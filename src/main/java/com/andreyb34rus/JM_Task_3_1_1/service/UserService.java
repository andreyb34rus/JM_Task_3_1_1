package com.andreyb34rus.JM_Task_3_1_1.service;

import com.andreyb34rus.JM_Task_3_1_1.model.User;
import com.andreyb34rus.JM_Task_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
