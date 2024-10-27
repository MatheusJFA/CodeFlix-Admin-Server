package com.matheusjfa.codeflix.admin.domain.category;

import com.matheusjfa.codeflix.admin.domain.AggregateRoot;
import com.matheusjfa.codeflix.admin.domain.validation.ValidationHandler;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {
    private final String name;
    private final String description;
    private final boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    public Category(final CategoryID id,
                    final String name,
                    final String description,
                    final boolean active,
                    final Instant createdAt,
                    final Instant updatedAt,
                    final Instant deletedAt) {
        super(id);
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Category New(final String name,
                               final String description,
                               final boolean active) {
        CategoryID id = CategoryID.generate();
        Instant now = Instant.now();
        Instant deletedAt = active ? null : now;
        return new Category(id, name, description, active, now, now, deletedAt);
    }

    public CategoryID getId() {
        return id;
    }

    @Override
    public void validate(ValidationHandler handler) {
        CategoryValidator validator = new CategoryValidator(this, handler);
        validator.validate();
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
