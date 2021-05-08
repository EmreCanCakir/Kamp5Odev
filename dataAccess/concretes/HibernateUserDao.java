package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;


public class HibernateUserDao implements UserDao {

    private List<User> userList;
    public HibernateUserDao() {
        userList = new ArrayList<>(10);
    }

    @Override
    public void enterFirstName(User user) {
        System.out.println("Kullanicinin ismi : "+user.getFirstName());
    }

    @Override
    public void enterLastName(User user) {
        System.out.println("Kullanicinin soyadi :"+user.getLastName());
    }

    @Override
    public void enterEPosta(User user) {
        System.out.println("Kullanicinin eposta adresi :"+user.geteMail());
    }

    @Override
    public void enterPassword(User user) {
        System.out.println("Kullanicinin sifresi :"+user.getPassword());
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
    public boolean loginByCheck(String email, String password){
        for(User user : userList){
            if(user.geteMail() == email && user.getPassword() == password)
                return true;
        }
        return false;

    }

    @Override
    public void add(User user) {
        userList.add(user);
        System.out.println("Kullanıcı eklendi: " + user.getFirstName() + " " + user.geteMail());
    }

}

