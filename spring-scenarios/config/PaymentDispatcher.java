package config;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentDispatcher {

    // Spring auto-populates map with bean names as keys
    private final Map<String, PaymentStrategy> paymentStrategies;

    public PaymentDispatcher(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public void routePayment(String paymentType, double amount) {
        PaymentStrategy strategy = paymentStrategies.get(paymentType.toUpperCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
        strategy.executePayment(amount);
    }
}
