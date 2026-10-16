package patterns;

public class PasswordChecker {
    public static String evaluateStrength(String password) {
        if (password == null || password.length() < 8) {
            return "Weak password";
        }
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }
        return (hasUpper && hasLower && hasDigit && hasSpecial) ? "Strong password" : "Weak password";
    }
}
