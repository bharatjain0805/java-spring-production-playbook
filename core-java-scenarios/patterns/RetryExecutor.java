package patterns;

import java.util.concurrent.Callable;

public class RetryExecutor {
    public static <T> T executeWithRetry(Callable<T> task, int maxRetries, long delayMs) throws Exception {
        int attempts = 0;
        while (true) {
            try {
                return task.call();
            } catch (Exception e) {
                attempts++;
                if (attempts >= maxRetries) throw e;
                Thread.sleep(delayMs);
            }
        }
    }
}
