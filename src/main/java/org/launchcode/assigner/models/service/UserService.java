package org.launchcode.assigner.models.service;



import org.launchcode.assigner.models.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
