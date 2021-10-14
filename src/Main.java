import business.abstracts.UserService;
import business.concretes.EmailVerify;
import business.concretes.UserManager;
import business.concretes.ValidUserManager;
import core.GoogleAuthenticationManagerAdapter;
import dataAccess.concretes.SqlUserDao;
import entities.concretes.User;


public class Main {

    public static void main(String[] args) {
        User user = new User("Metin", "Yüce", "myuceogu@gmail.com", "123456");
        UserService userService = new UserManager(new ValidUserManager(new SqlUserDao()), new SqlUserDao(), new EmailVerify(), new GoogleAuthenticationManagerAdapter());
        userService.register(user);


        userService.login("myuceogu@gmail.com", "123456");
        userService.loginWithGoogle("myuceogu@gmail.com");
    }
}
