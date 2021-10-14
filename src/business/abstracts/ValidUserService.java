package business.abstracts;

import entities.concretes.User;

public interface ValidUserService {
    boolean validEmail(User user);

    boolean validName(User user);

    boolean validPassword(User user);

    boolean validUsedEmail(User user);
}
