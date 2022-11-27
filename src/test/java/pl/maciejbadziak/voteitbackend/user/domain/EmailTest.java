package pl.maciejbadziak.voteitbackend.user.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.user.domain.error.InvalidEmailException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class EmailTest {

    private static final String VALID_EMAIL = "valid@mail.com";
    private static final String INVALID_EMAIL_WITHOUT_AT = "invalid-mail.com";
    private static final String INVALID_EMAIL_WITHOUT_DOT = "invalid@emailcom";
    private static final String INVALID_TOO_SHORT_EMAIL = "x@x.x";
    private static final String EXCEPTION_MESSAGE = "Email [%s] is not valid";
    private static final String MAIL_SUFFIX = "@mail.com";
    private static final int SUFFIX_LENGTH = MAIL_SUFFIX.length();
    private static final int MAX_LENGTH = 320 - SUFFIX_LENGTH + 1;
    private static final String INVALID_TOO_LONG_EMAIL = generateTooLongEmail();

    private static String generateTooLongEmail() {
        String email = IntStream.range(0, MAX_LENGTH)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
        return email + MAIL_SUFFIX;
    }

    @Test
    void shouldCreateValidEmail() {
        // given
        // when
        // then
        assertThat(Email.of(VALID_EMAIL).getValue()).isEqualTo(VALID_EMAIL);
    }

    @Test
    void shouldRejectInvalidEmailWithoutAt() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Email.of(INVALID_EMAIL_WITHOUT_AT));

        // then
        assertThat(result)
                .isInstanceOf(InvalidEmailException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMAIL_WITHOUT_AT);
    }

    @Test
    void shouldRejectInvalidEmailWithoutDot() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Email.of(INVALID_EMAIL_WITHOUT_DOT));

        // then
        assertThat(result)
                .isInstanceOf(InvalidEmailException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMAIL_WITHOUT_DOT);
    }

    @Test
    void shouldRejectInvalidTooShortEmail() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Email.of(INVALID_TOO_SHORT_EMAIL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidEmailException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_SHORT_EMAIL);
    }

    @Test
    void shouldRejectInvalidTooLongEmail() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Email.of(INVALID_TOO_LONG_EMAIL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidEmailException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_EMAIL);
    }
}
