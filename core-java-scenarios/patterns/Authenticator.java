package patterns;

public interface Authenticator {
    boolean authenticate(String user, String credential);
}

class PasswordAuthenticator implements Authenticator {
    public boolean authenticate(String user, String pass) { return true; }
}

class OAuthAuthenticator implements Authenticator {
    public boolean authenticate(String user, String token) { return true; }
}
