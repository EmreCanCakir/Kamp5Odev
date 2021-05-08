import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.LoggerManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserManager(new HibernateUserDao(), new LoggerManager());
        User user1 = new User(1, "Emre", "Çakır", "emreecann28@gmail.com", "123456");

        User user2 = new User(2, "Engin", "Demirog", "engindemirog@gmail.com", "1234567");

        System.out.println("Sisteme kayit olmak icin : ");
        userService.enterFirstName(user1);
        userService.enterLastName(user1);
        userService.enterPassword(user1);
        userService.enterEPosta(user1);
        userService.add(user1);
        userService.add(user2);

        System.out.println("---------------------------");


        System.out.println("Sisteme giris icin : ");
        userService.logIn(user1.geteMail(), user1.getPassword());
        userService.getAll();
    }
}
