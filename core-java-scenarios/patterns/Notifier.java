package patterns;

public interface Notifier {
    void sendNotification(String message, String to);
}

class EmailNotifier implements Notifier {
    public void sendNotification(String message, String to) {
        System.out.println("EMAIL to " + to + ": " + message);
    }
}

class SmsNotifier implements Notifier {
    public void sendNotification(String message, String to) {
        System.out.println("SMS to " + to + ": " + message);
    }
}