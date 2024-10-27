package com.matheusjfa.codeflix.admin.domain.validation.handler;

import com.matheusjfa.codeflix.admin.domain.exceptions.DomainException;
import com.matheusjfa.codeflix.admin.domain.validation.Error;
import com.matheusjfa.codeflix.admin.domain.validation.Validation;
import com.matheusjfa.codeflix.admin.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {

    @Override
    public ValidationHandler append(Error error) {
        throw DomainException.with(List.of(error));
    }

    @Override
    public ValidationHandler append(ValidationHandler handler) {
        throw DomainException.with(handler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation validation) {
        try {
            validation.validate();
        } catch (final Exception e) {
            throw DomainException.with(List.of(new Error(e.getMessage())));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }


}
