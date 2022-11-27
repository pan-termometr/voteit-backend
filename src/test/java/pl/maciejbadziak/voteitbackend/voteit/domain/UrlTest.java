package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidUrlException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class UrlTest {

    private static final String VALID_URL = "https://valid.url";
    private static final String INVALID_TOO_LONG_URL = generateTooLongUrl();
    private static final String INVALID_EMPTY_URL = "";
    private static final String EXCEPTION_MESSAGE = "Url [%s] is not valid";
    private static final String DOMAIN_PREFIX = "https://";
    private static final String DOMAIN_SUFFIX = ".com";
    private static final int PREFIX_LENGTH = DOMAIN_PREFIX.length();
    private static final int SUFFIX_LENGTH = DOMAIN_SUFFIX.length();
    private static final int MAX_LENGTH = 2048 - PREFIX_LENGTH - SUFFIX_LENGTH;

    @Test
    void shouldCreateValidUrl() {
        // given
        // when
        // then
        assertThat(Url.of(VALID_URL).getValue()).isEqualTo(VALID_URL);
    }

    private static String generateTooLongUrl() {
        String domain = IntStream.range(0, MAX_LENGTH)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
        return "https://" + domain + ".pl";
    }

    @Test
    void shouldRejectInvalidTooLongUrl() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Url.of(INVALID_TOO_LONG_URL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUrlException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_URL);
    }

    @Test
    void shouldRejectEmptyUrl() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Url.of(INVALID_EMPTY_URL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUrlException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_URL);
    }
}
