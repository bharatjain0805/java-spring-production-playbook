package concurrency;

public class DeadlockPrevention {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void safeMethod1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Thread 1 acquired lock1 and lock2");
            }
        }
    }

    public static void safeMethod2() {
        // Prevention: Acquire locks in the exact same global order
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock1 and lock2");
            }
        }
    }
}
