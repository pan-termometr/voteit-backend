package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailValidatorTest {

    private final EmailValidator emailValidator = new EmailValidator();

    private static Stream<Object[]> emailValidationParameters() {
        return Stream.of(
                // Valid emails
                new Object[]{"test@example.com", true},
                new Object[]{"user@domain.co", true},
                new Object[]{"john.doe123@company.org", true},

                // Invalid emails
                new Object[]{"invalid-email", false},
                new Object[]{"user@domain", false},
                new Object[]{"user@.com", false},
                new Object[]{"user@domain..com", false},
                new Object[]{"user@domain.c", false},

                // Null email
                new Object[]{null, false}
        );
    }

    @ParameterizedTest
    @MethodSource("emailValidationParameters")
    void testEmailValidation(String email, boolean expected) {
        // when
        final boolean actual = emailValidator.isValid(email, null);

        // then
        assertEquals(expected, actual);
    }
}
