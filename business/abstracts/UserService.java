package business.abstracts;

import entities.concretes.User;



public interface UserService {
    void enterFirstName(User user);
    void enterLastName(User user);
    void enterEPosta(User user);
    void enterPassword(User user);
    void add(User user);
    void getAll();
    void logIn(String email, String password);
}
