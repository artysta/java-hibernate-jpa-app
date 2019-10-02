package pl.adriankurek.api;

import java.util.List;

import pl.adriankurek.model.User;

public interface UserDataApi {
    List<User> getUsers();
    void insertUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}