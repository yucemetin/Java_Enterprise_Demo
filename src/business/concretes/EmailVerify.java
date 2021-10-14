package business.concretes;

import business.abstracts.Verify;
import entities.concretes.User;

import java.util.Scanner;

public class EmailVerify implements Verify {

    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean verify(User user) {
        System.out.print("Email adresi : " + user.getEmail() + " olan üye lütfen emailinize gelen kodu doğrulayın. (1) Doğrula , (2) Doğrulama :");
        int answer = scanner.nextInt();

        if (answer == 1) {
            return true;
        }

        return false;
    }
}
