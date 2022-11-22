package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidTag;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class TagTest {

    private static final String VALID_TAG = "validtag";
    private static final String INVALID_TAG_WITH_CAPITAL_LETTER = "Invalidtag";
    private static final String INVALID_EMPTY_TAG = "";
    private static final String INVALID_TOO_LONG_TAG = generateTooLongTag();
    private static final String EXCEPTION_MESSAGE = "Tag [%s] is not valid";
    private static final int MAX_LENGTH = 30;

    private static String generateTooLongTag() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldCreateValidTag() {
        // given
        // when
        // then
        assertThat(Tag.of(VALID_TAG).getValue()).isEqualTo(VALID_TAG);
    }

    @Test
    void shouldRejectInvalidTagWithCapitalLetter() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Tag.of(INVALID_TAG_WITH_CAPITAL_LETTER));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTag.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TAG_WITH_CAPITAL_LETTER);
    }

    @Test
    void shouldRejectInvalidTooLongTag() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Tag.of(INVALID_TOO_LONG_TAG));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTag.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_TAG);
    }

    @Test
    void shouldRejectInvalidEmptyTag() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Tag.of(INVALID_EMPTY_TAG));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTag.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_TAG);
    }
}
