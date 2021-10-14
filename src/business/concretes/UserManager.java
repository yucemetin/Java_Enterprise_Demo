package business.concretes;

import business.abstracts.UserService;
import business.abstracts.ValidUserService;
import business.abstracts.Verify;
import core.AuthenticationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

    private ValidUserService validUserService;
    private UserDao userDao;
    private Verify verify;
    private AuthenticationService authenticationService;

    public UserManager(ValidUserService validUserService, UserDao userDao, Verify verify, AuthenticationService authenticationService) {
        this.validUserService = validUserService;
        this.userDao = userDao;
        this.verify = verify;
        this.authenticationService = authenticationService;
    }


    @Override
    public void register(User user) {
        if (!validUserService.validEmail(user) || !validUserService.validName(user) || !validUserService.validPassword(user) || !validUserService.validUsedEmail(user)) {
            System.out.println("Üye kaydı başarısız oldu !!!");
            return;
        }
        if (verify.verify(user)) {
            System.out.println("Üye kaydı başarıyla gerçekleştirildi...");
            userDao.add(user);
        } else {
            System.out.println("Üyelik doğrulanmadı !!");
        }


    }

    @Override
    public void login(String email, String password) {
        for (User user : userDao.getAll()) {
            if (user.getEmail() == email && user.getPassword() == password) {
                System.out.println("Giriş başarıyla gerçekleştirildi...");
                break;
            } else {
                System.out.println("Parola ya da email hatalı !!");
                break;
            }
        }
    }

    @Override
    public void loginWithGoogle(String email) {
        authenticationService.authentication(email);
    }
}
