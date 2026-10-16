package config;
import org.springframework.stereotype.Service;
import java.util.Map;

public interface PaymentStrategy {
    void executePayment(double amount);
}

@Service("CARD")
class CardStrategy implements PaymentStrategy {
    public void executePayment(double amount) { /* Card processing */ }
}

@Service("UPI")
class UpiStrategy implements PaymentStrategy {
    public void executePayment(double amount) { /* UPI processing */ }
}

