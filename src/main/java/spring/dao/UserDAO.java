package spring.dao;

import spring.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUserList();
    User show(int id);
    void save(User user);
    void update(User user);
    void delete(int id);
}
