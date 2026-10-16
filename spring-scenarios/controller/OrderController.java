package controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final StringRedisTemplate redisTemplate;

    public OrderController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @RequestBody OrderRequest request) {

        // Atomically reserve key for 5 minutes
        Boolean isFirstRequest = redisTemplate.opsForValue()
                .setIfAbsent("idemp:" + idempotencyKey, "LOCKED", Duration.ofMinutes(5));

        if (Boolean.FALSE.equals(isFirstRequest)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Request with this key is already being processed or finished.");
        }

        // Execute payment/order processing logic
        return ResponseEntity.status(HttpStatus.CREATED).body("Order confirmed");
    }
}
