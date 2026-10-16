package patterns;

import java.util.List;

record CartItem(String name, double price, int quantity) {}

public class CartBilling {
    public static double calculateCartTotal(List<CartItem> items) {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.price() * item.quantity();
            if (total > 10000) {
                System.out.println("Max cart limit reached. Halting further items.");
                break;
            }
        }
        if (total > 5000) {
            System.out.println("10% discount applied.");
            total = total * 0.90;
        }
        return total;
    }
}