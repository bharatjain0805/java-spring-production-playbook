package patterns;

public final class AppLogger {
    private AppLogger() {}

    public static void log(String message) {
        System.out.println("[" + java.time.LocalDateTime.now() + "] " + message);
    }
}
