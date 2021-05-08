package business.concretes;

import business.abstracts.ValidationService;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationManager implements ValidationService {

        private List<User> userArray= new ArrayList<>();
        public ValidationManager(List<User> userArray){
            this.userArray=userArray;
        }
        public ValidationManager(){

        }

    @Override
    public boolean firstNameValidation(User user) {
        if (user.getFirstName() == null || user.getFirstName().length() < 2) {
            return false;
        }
        for (char c : user.getFirstName().toCharArray()) {
            if (Character.isDigit(c))
                return false;

        }
        return true;
    }

    @Override
    public boolean lastNameValidation(User user) {
        if (user.getLastName() == null || user.getLastName().length() < 2) {
            return false;
        }
        for (char c : user.getLastName().toCharArray()) {
            if (Character.isDigit(c))
                return false;

        }
        return true;
    }

    @Override
    public boolean eMailValidation(User user) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (user.geteMail() == null)
            return false;
        return pat.matcher(user.geteMail()).matches();

    }

    @Override
    public boolean passwordValidation(User user) {
        if(user.getPassword()==null || user.getPassword().length()<6){
            return false;
        }
        return true;
    }

    @Override
    public boolean isEMailAlreadyExist(String email) {
        for(User user : userArray){
            if (user.geteMail().equals(email)){
                return true;
            }
        }
        return false;
    }





}
