package business.abstracts;

import entities.concretes.User;

public interface ValidationService {
    public boolean firstNameValidation(User user);
    public boolean lastNameValidation(User user);
    public boolean eMailValidation(User user);
    public boolean passwordValidation(User user);
    public boolean isEMailAlreadyExist(String email);

}
