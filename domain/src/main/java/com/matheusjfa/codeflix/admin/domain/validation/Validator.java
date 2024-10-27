package com.matheusjfa.codeflix.admin.domain.validation;

public abstract class Validator {
    private final ValidationHandler handler;

    protected Validator(ValidationHandler handler) {
        this.handler = handler;
    }

    public abstract void validate();

    protected ValidationHandler getHandler() {
        return handler;
    }
}
