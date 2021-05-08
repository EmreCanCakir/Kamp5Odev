package business.concretes;

import business.abstracts.UserService;
import business.abstracts.ValidationService;
import core.abstracts.LoggerService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;




public class UserManager implements UserService {
    private UserDao userDao;
    private LoggerService loggerService;
    private ValidationService validationService;

    public UserManager(UserDao userDao, LoggerService loggerService) {
        this.userDao = userDao;
        this.loggerService = loggerService;
    }

    ValidationService validationManager = new ValidationManager();

    @Override
    public void enterFirstName(User user) {
        if (validationManager.firstNameValidation(user) == true) {
            userDao.enterFirstName(user);
        } else {
            System.out.println("Kullanicinin isim bilgisi gecersiz lutfen tekrar deneyin");
        }
    }

    @Override
    public void enterLastName(User user) {
        if (validationManager.lastNameValidation(user) == true) {
            userDao.enterLastName(user);
        } else {
            System.out.println("Kullanicinin soyad bilgisi gecersiz lutfen tekrar deneyin");
        }

    }

    @Override
    public void enterEPosta(User user) {
        if (validationManager.eMailValidation(user) == true || validationManager.isEMailAlreadyExist(user.geteMail()) == false) {
            userDao.enterEPosta(user);
            loggerService.Log("Lütfen 2 dk içinde doğrulamayı yapınız");

        } else {
            System.out.println("Kullanicinin e posta bilgisi gecersiz lutfen tekrar deneyin");
        }

    }

    @Override
    public void enterPassword(User user) {
        if (validationManager.passwordValidation(user) == true) {
            userDao.enterPassword(user);

        } else {
            System.out.println("Kullanicinin parola bilgisi gecersiz lutfen tekrar deneyin");
        }
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void logIn(String email, String password) {
        if (userDao.loginByCheck(email, password)==true){
            System.out.println("Başarıyla giriş yapıldı!");
        }else {
        System.out.println("Giriş başarısız! Hatalı email veya parola!");
    }}

    @Override
    public void getAll() {
        System.out.println("Kullanıcı listeleri: ");
        int i = 1;
        for(User user : userDao.getAll()){
            System.out.println(i + "- " + user.getFirstName() + " " + user.getLastName() + " " + user.geteMail());
            i++;}
    }
  }
