package pl.maciejbadziak.voteitbackend.tag.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.error.InvalidTagnameException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class TagnameTest {

    private static final String VALID_TAGNAME = "valid-tagname1";
    private static final String INVALID_TAGNAME_WITH_CAPITAL_LETTER = "Invalidtagname";
    private static final String INVALID_EMPTY_TAGNAME = "";
    private static final String EXCEPTION_MESSAGE = "Tagname [%s] is not valid";
    private static final int MAX_LENGTH = 30;
    private static final String INVALID_TOO_LONG_TAGNAME = generateTooLongTagname();

    private static String generateTooLongTagname() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldCreateValidTag() {
        // given
        // when
        // then
        assertThat(Tagname.of(VALID_TAGNAME).getValue()).isEqualTo(VALID_TAGNAME);
    }

    @Test
    void shouldRejectInvalidTagWithCapitalLetter() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Tagname.of(INVALID_TAGNAME_WITH_CAPITAL_LETTER));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTagnameException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TAGNAME_WITH_CAPITAL_LETTER);
    }

    @Test
    void shouldRejectInvalidTooLongTag() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Tagname.of(INVALID_TOO_LONG_TAGNAME));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTagnameException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_TAGNAME);
    }

    @Test
    void shouldRejectInvalidEmptyTag() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Tagname.of(INVALID_EMPTY_TAGNAME));

        // then
        assertThat(result)
                .isInstanceOf(InvalidTagnameException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_TAGNAME);
    }
}
