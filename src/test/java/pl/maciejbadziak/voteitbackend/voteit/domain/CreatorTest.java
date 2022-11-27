package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidCreatorException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CreatorTest {

    private static final String VALID_CREATOR = "valid_creator";
    private static final String INVALID_CREATOR_WITH_CAPITAL_LETTER = "Invalid_creator";
    private static final String INVALID_EMPTY_CREATOR = "";
    private static final String INVALID_TOO_LONG_CREATOR = generateTooLongCreator();
    private static final String EXCEPTION_MESSAGE = "Creator [%s] is not valid";
    private static final int MAX_LENGTH = 30;

    @Test
    void shouldCreateValidCreator() {
        // given
        // when
        // then
        assertThat(Creator.of(VALID_CREATOR).getValue()).isEqualTo(VALID_CREATOR);
    }

    private static String generateTooLongCreator() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldRejectInvalidCreatorWithCapitalLetter() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Creator.of(INVALID_CREATOR_WITH_CAPITAL_LETTER));

        // then
        assertThat(result)
                .isInstanceOf(InvalidCreatorException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_CREATOR_WITH_CAPITAL_LETTER);
    }

    @Test
    void shouldRejectInvalidTooLongCreator() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Creator.of(INVALID_TOO_LONG_CREATOR));

        // then
        assertThat(result)
                .isInstanceOf(InvalidCreatorException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_CREATOR);
    }

    @Test
    void shouldRejectInvalidEmptyCreator() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Creator.of(INVALID_EMPTY_CREATOR));

        // then
        assertThat(result)
                .isInstanceOf(InvalidCreatorException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_CREATOR);
    }
}
