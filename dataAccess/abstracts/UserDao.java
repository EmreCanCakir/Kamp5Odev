package dataAccess.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserDao {
    void enterFirstName(User user);
    void enterLastName(User user);
    void enterEPosta(User user);
    void enterPassword(User user);
    List<User> getAll();
    boolean loginByCheck(String email, String password);
    void add(User user);
}
