package com.example._52000691Lab9.iservice;

import com.example._52000691Lab9.model.Product;
import com.example._52000691Lab9.model.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();
    User selectById(Integer id);
    User insert(User user);
    boolean deleteById(Integer id);
    User update(User userUpdate);
}
