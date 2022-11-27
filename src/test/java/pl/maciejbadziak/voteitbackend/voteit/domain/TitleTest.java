package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidTitleException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class TitleTest {

    private static final String VALID_TITLE = "Valid title";
    private static final String INVALID_EMPTY_TITLE = "";
    private static final String INVALID_TOO_LONG_TITLE = generateTooLongTitle();
    private static final String EXCEPTION_MESSAGE = "Title [%s] is not valid";
    private static final int MAX_LENGTH = 80;

    private static String generateTooLongTitle() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldCreateValidTitle() {
        // given
        // when
        // then
        assertThat(Title.of(VALID_TITLE).getValue()).isEqualTo(VALID_TITLE);
    }

    @Test
    void shouldRejectInvalidTooLongTitle() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Title.of(INVALID_TOO_LONG_TITLE));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTitleException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_TITLE);
    }

    @Test
    void shouldRejectEmptyTitle() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Title.of(INVALID_EMPTY_TITLE));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTitleException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_TITLE);
    }
}
