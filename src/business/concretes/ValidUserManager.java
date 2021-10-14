package business.concretes;

import business.abstracts.ValidUserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUserManager implements ValidUserService {

    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final UserDao userDao;

    public ValidUserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean validEmail(User user) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if (matcher.find()) {
            return true;
        } else {
            System.out.println("Email formata uymuyor !!!");
            return false;
        }

    }

    @Override
    public boolean validName(User user) {
        if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
            System.out.println("İsim ve Soyisim 2 harften az olamaz !!!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validPassword(User user) {
        if (user.getPassword().length() < 6) {
            System.out.println("Parola 6 harften az olamaz !!!");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validUsedEmail(User user) {
        if (!userDao.getAll().isEmpty()) {
            for (User userList : userDao.getAll()) {
                if (userList.getEmail() == user.getEmail()) {
                    System.out.println("Girdiğiniz email daha önce kullanılmış !!!");
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;
    }
}


