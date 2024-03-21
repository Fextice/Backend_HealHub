package com.example.healhub.Repository;

import com.example.healhub.Entity.User;
import java.util.List;

public interface AdminService {
    List<User> getAllUsers();
    void addUser(User user);
}
