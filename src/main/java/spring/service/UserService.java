package spring.service;

import spring.model.User;

import java.util.List;


public interface UserService {
    public List<User> getListFromService();
    User show(int id);
    public void save(User user);
    public void update(User updatedUser);
    public void delete(int id);
}
