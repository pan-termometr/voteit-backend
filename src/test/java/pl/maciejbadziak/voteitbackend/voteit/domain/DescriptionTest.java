package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidDescription;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class DescriptionTest {

    private static final String VALID_DESCRIPTION = "Valid description";
    private static final String INVALID_EMPTY_DESCRIPTION = "";
    private static final String INVALID_TOO_LONG_DESCRIPTION = generateTooLongDescription();
    private static final String EXCEPTION_MESSAGE = "Description [%s] is not valid";
    private static final int MAX_LENGTH = 300;

    private static String generateTooLongDescription() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldCreateValidDescription() {
        // given
        // when
        // then
        assertThat(Description.of(VALID_DESCRIPTION).getValue()).isEqualTo(VALID_DESCRIPTION);
    }

    @Test
    void shouldRejectInvalidTooLongDescription() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Description.of(INVALID_TOO_LONG_DESCRIPTION));

        // then
        assertThat(result)
                .isInstanceOf(InvalidDescription.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_DESCRIPTION);
    }

    @Test
    void shouldRejectEmptyDescription() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Description.of(INVALID_EMPTY_DESCRIPTION));

        // then
        assertThat(result)
                .isInstanceOf(InvalidDescription.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_DESCRIPTION);
    }
}
