package core;

import JGoogleAuthentication.GoogleAuthenticationManager;

public class GoogleAuthenticationManagerAdapter implements AuthenticationService {

    @Override
    public void authentication(String email) {
        GoogleAuthenticationManager googleAuthenticationManager = new GoogleAuthenticationManager();
        googleAuthenticationManager.authentication(email);
    }
}
