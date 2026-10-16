package concurrency;

public class AlphaNumericSequence {
    private boolean isLetterTurn = true;
    private final Object monitor = new Object();

    public void printLetters() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            synchronized (monitor) {
                while (!isLetterTurn) {
                    try { monitor.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
                System.out.print(ch + " ");
                isLetterTurn = false;
                monitor.notify();
            }
        }
    }

    public void printNumbers() {
        for (int i = 1; i <= 26; i++) {
            synchronized (monitor) {
                while (isLetterTurn) {
                    try { monitor.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
                System.out.print(i + " ");
                isLetterTurn = true;
                monitor.notify();
            }
        }
    }

    public static void main(String[] args) {
        AlphaNumericSequence seq = new AlphaNumericSequence();
        new Thread(seq::printLetters).start();
        new Thread(seq::printNumbers).start();
    }
}
