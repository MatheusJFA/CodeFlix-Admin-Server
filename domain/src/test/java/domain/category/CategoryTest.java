package domain.category;

import com.matheusjfa.codeflix.admin.domain.category.Category;
import com.matheusjfa.codeflix.admin.domain.exceptions.DomainException;
import com.matheusjfa.codeflix.admin.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void givenAValidParameters_whenCreateCategory_thenCategoryIsCreated() {
        // Given
        String expectedName = "Category Name";
        String expectedDescription = "Category Description";
        Boolean expectedActive = true;

        // When
        Category category = Category.New(expectedName, expectedDescription, expectedActive);

        // Then
        // Assertions
        Assertions.assertNotNull(category);
        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals(expectedName, category.getName());
        Assertions.assertEquals(expectedDescription, category.getDescription());
        Assertions.assertEquals(expectedActive, category.isActive());

        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getUpdatedAt());
        Assertions.assertNull(category.getDeletedAt());
    }

    @Test
    public void givenAnEmptyDescription_whenCreateCategory_thenCategoryIsCreated() {
        // Given
        String expectedName = "Category Name";
        String expectedDescription = "";
        Boolean expectedActive = true;

        // When
        Category category = Category.New(expectedName, expectedDescription, expectedActive);

        // Then
        // Assertions
        Assertions.assertNotNull(category);
        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals(expectedName, category.getName());
        Assertions.assertEquals(expectedDescription, category.getDescription());
        Assertions.assertEquals(expectedActive, category.isActive());

        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getUpdatedAt());
        Assertions.assertNull(category.getDeletedAt());
    }

    @Test
    public void givenAnInactiveCategory_whenCreateCategory_thenCategoryIsCreated() {
        // Given
        String expectedName = "Category Name";
        String expectedDescription = "Category Description";
        Boolean expectedActive = false;

        // When
        Category category = Category.New(expectedName, expectedDescription, expectedActive);

        // Then
        // Assertions
        Assertions.assertNotNull(category);
        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals(expectedName, category.getName());
        Assertions.assertEquals(expectedDescription, category.getDescription());
        Assertions.assertEquals(expectedActive, category.isActive());

        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getUpdatedAt());
        Assertions.assertNotNull(category.getDeletedAt());
    }

    @Test
    public void givenAnEmptyName_whenCreateCategoryAndValidate_thenCategoryIsNotCreated() {
        // Given
        String expectedName = null;
        String expectedDescription = "Category Description";
        Boolean expectedActive = true;

        String expectedMessage = "'Name' should not be null";
        int expectedErrorCount = 1;

        // When
        Category category = Category.New(expectedName, expectedDescription, expectedActive);
        ThrowsValidationHandler handler = new ThrowsValidationHandler();

        // Then
        // Assertions
        final var exception = Assertions.assertThrows(DomainException.class, () -> category.validate(handler));

        Assertions.assertEquals(expectedMessage, exception.getErrors().getFirst().message());
        Assertions.assertEquals(expectedErrorCount, exception.getErrors().size());
    }

}
