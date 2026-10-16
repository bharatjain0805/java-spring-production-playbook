package service;

import jakarta.persistence.*;

@Entity
public class InventoryItem {
    @Id
    private Long id;
    private int quantity;

    @Version // Optimistic lock counter; throws OptimisticLockException on collision
    private Long version;

    // Getters and Setters
}
