package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

class PasswordMatchesValidatorTest {

    private final PasswordMatchesValidator passwordMatchesValidator = new PasswordMatchesValidator();

    private static Stream<Arguments> passwordMatchProvider() {
        return Stream.of(
                // matching passwords
                Arguments.of(
                        testUser().withPassword("matching-password").withMatchingPassword("matching-password"),
                        true
                ),

                // not matching passwords
                Arguments.of(
                        testUser().withPassword("matching-password").withMatchingPassword("not matching password"),
                        false
                ),

                // null passwords
                Arguments.of(
                        testUser().withPassword(null).withMatchingPassword(null),
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("passwordMatchProvider")
    void shouldReturnCorrectValidationResult(User user, boolean expectedResult) {
        // when
        final boolean result = passwordMatchesValidator.isValid(user, mock(ConstraintValidatorContext.class));

        // then
        assertEquals(expectedResult, result);
    }
}