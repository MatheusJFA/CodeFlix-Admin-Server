package com.matheusjfa.codeflix.admin.domain.category;

import com.matheusjfa.codeflix.admin.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {
    private final String value;

    public CategoryID(final String value) {
        Objects.requireNonNull(value, "Id should not be null");
        this.value = value;
    }

    public static CategoryID generate() {
        return CategoryID.from(UUID.randomUUID());
    }

    public static CategoryID from(final String value) {
        return new CategoryID(value);
    }

    public static CategoryID from(final UUID value) {
        return new CategoryID(value.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return Objects.equals(value, that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
