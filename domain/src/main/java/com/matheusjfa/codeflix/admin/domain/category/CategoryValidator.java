package com.matheusjfa.codeflix.admin.domain.category;

import com.matheusjfa.codeflix.admin.domain.validation.Error;
import com.matheusjfa.codeflix.admin.domain.validation.ValidationHandler;
import com.matheusjfa.codeflix.admin.domain.validation.Validator;

public class CategoryValidator extends Validator {
    private final int MINIMUN_NAME_LENGTH = 3;
    private final int MAXIMUM_NAME_LENGTH = 255;

    private Category category;

    public CategoryValidator(final Category category, final ValidationHandler handler) {
        super(handler);
        this.category = category;
    }

    @Override
    public void validate() {
        nameConstraintValidation();
    }

    private void nameConstraintValidation() {
        final var name = category.getName();
        final var length = name != null ? name.trim().length() : 0;

        if(name == null)
            this.getHandler().append(new Error("'Name' should not be null"));
        else if (name.isBlank() || name.isEmpty())
                this.getHandler().append(new Error("'Name' should not be empty"));
        else if (length < MINIMUN_NAME_LENGTH || length > MAXIMUM_NAME_LENGTH)
                this.getHandler().append(new Error("'Name' must be between 3 and 255 characters"));
    }
}
