package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessingService {

    // Checked exceptions require explicit declaration in rollbackFor
    @Transactional(rollbackFor = Exception.class)
    public void processPayment(Long orderId) throws Exception {
        updateInventory(orderId);
        triggerExternalCharge(orderId); // Throws IOException on connection failure
    }

    // CAUTION: Calling processPayment() directly from within this class
    // bypasses the Spring CGLIB transaction proxy. Inject the service
    // bean or separate it into another component.
    private void updateInventory(Long orderId) {
        // DB modification
    }

    private void triggerExternalCharge(Long orderId) throws Exception {
        throw new Exception("Gateway timeout");
    }
}
