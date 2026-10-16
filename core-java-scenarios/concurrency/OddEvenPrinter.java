package concurrency;

public class OddEvenPrinter {
    private int counter = 1;
    private final int limit = 20;
    private boolean isOddTurn = true;

    public synchronized void printOdd() {
        while (counter <= limit) {
            while (!isOddTurn) {
                try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            if (counter <= limit) {
                System.out.println(Thread.currentThread().getName() + ": " + counter++);
            }
            isOddTurn = false;
            notify();
        }
    }

    public synchronized void printEven() {
        while (counter <= limit) {
            while (isOddTurn) {
                try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            if (counter <= limit) {
                System.out.println(Thread.currentThread().getName() + ": " + counter++);
            }
            isOddTurn = true;
            notify();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter();
        Thread oddThread = new Thread(printer::printOdd, "Odd-Thread");
        Thread evenThread = new Thread(printer::printEven, "Even-Thread");
        oddThread.start();
        evenThread.start();
    }
}