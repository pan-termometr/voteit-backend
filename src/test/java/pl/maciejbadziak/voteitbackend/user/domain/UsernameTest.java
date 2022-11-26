package pl.maciejbadziak.voteitbackend.user.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.user.domain.error.InvalidUsernameException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class UsernameTest {

    private static final String VALID_USERNAME = "valid_username";
    private static final String INVALID_USERNAME_WITH_CAPITAL_LETTER = "Invalid_username";
    private static final String INVALID_EMPTY_USERNAME = "";
    private static final String EXCEPTION_MESSAGE = "Username [%s] is not valid";
    private static final int MAX_LENGTH = 30;
    private static final String INVALID_TOO_LONG_USERNAME = generateTooLongUsername();

    private static String generateTooLongUsername() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldCreateValidUsername() {
        // given
        // when
        // then
        assertThat(Username.of(VALID_USERNAME).getValue()).isEqualTo(VALID_USERNAME);
    }

    @Test
    void shouldRejectInvalidUsernameWithCapitalLetter() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Username.of(INVALID_USERNAME_WITH_CAPITAL_LETTER));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUsernameException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_USERNAME_WITH_CAPITAL_LETTER);
    }

    @Test
    void shouldRejectInvalidTooLongUsername() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Username.of(INVALID_TOO_LONG_USERNAME));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUsernameException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_USERNAME);
    }

    @Test
    void shouldRejectInvalidEmptyUsername() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Username.of(INVALID_EMPTY_USERNAME));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUsernameException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_USERNAME);
    }
}
