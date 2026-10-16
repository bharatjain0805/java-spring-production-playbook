package patterns;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) { super(msg); }
}

class EmailServerDownException extends Exception {
    public EmailServerDownException(String msg) { super(msg); }
}