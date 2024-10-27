package category;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {
    private String id;
    private final String name;
    private final String description;
    private final boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    public Category(String id, String name, String description, boolean active, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Category New(String name, String description, boolean active) {
        String id = UUID.randomUUID().toString();
        Instant now = Instant.now();
        Instant deletedAt = active ? null : now;
        return new Category(id, name, description, active, now, now, deletedAt);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

}
