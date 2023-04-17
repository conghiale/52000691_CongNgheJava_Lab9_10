package com.example._52000691Lab9.service;

import com.example._52000691Lab9.iservice.IUserService;
import com.example._52000691Lab9.model.User;
import com.example._52000691Lab9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> selectAll() {
        return userRepository.findAll();
    }

    @Override
    public User selectById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    @Override
    public User update(User userUpdate) {
        return userRepository.save(userUpdate);
    }
}
