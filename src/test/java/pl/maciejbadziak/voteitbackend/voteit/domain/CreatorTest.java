package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidCreator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CreatorTest {

    private static final String VALID_CREATOR = "valid_creator";
    private static final String INVALID_CREATOR_WITH_CAPITAL_LETTER = "Invalid_creator";
    private static final String INVALID_EMPTY_CREATOR = "";
    private static final int MAX_LENGTH = 30;
    private static final String INVALID_TOO_LONG_CREATOR = generateTooLongCreator();

    private static String generateTooLongCreator() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldCreateValidCreator() {
        // given
        // when
        // then
        assertThat(Creator.of(VALID_CREATOR).getValue()).isEqualTo(VALID_CREATOR);
    }

    @Test
    void shouldRejectInvalidCreatorWithCapitalLetter() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Creator.of(INVALID_CREATOR_WITH_CAPITAL_LETTER));

        // then
        assertThat(result)
                .isInstanceOf(InvalidCreator.class)
                .hasMessage("Creator [%s] is not valid", INVALID_CREATOR_WITH_CAPITAL_LETTER);
    }

    @Test
    void shouldRejectInvalidTooLongCreator() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Creator.of(INVALID_TOO_LONG_CREATOR));

        // then
        assertThat(result)
                .isInstanceOf(InvalidCreator.class)
                .hasMessage("Creator [%s] is not valid", INVALID_TOO_LONG_CREATOR);
    }

    @Test
    void shouldRejectInvalidEmptyCreator() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Creator.of(INVALID_EMPTY_CREATOR));

        // then
        assertThat(result)
                .isInstanceOf(InvalidCreator.class)
                .hasMessage("Creator [%s] is not valid", INVALID_EMPTY_CREATOR);
    }
}
