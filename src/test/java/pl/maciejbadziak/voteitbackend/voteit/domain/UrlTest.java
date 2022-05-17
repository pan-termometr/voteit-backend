package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidUrl;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class UrlTest {

    private static final String VALID_URL = "https://valid.url";
    private static final String INVALID_EMPTY_URL = "";
    private static final int HTTPS_LENGTH = 8;
    private static final int PL_LENGTH = 3;
    private static final int MAX_LENGTH = 2048 - HTTPS_LENGTH - PL_LENGTH;
    private static final String INVALID_TOO_LONG_URL = generateTooLongUrl();

    private static String generateTooLongUrl() {
        String domain = IntStream.range(0, MAX_LENGTH)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
        return "https://" + domain + ".pl";
    }

    @Test
    void shouldCreateValidUrl() {
        // given
        // when
        // then
        assertThat(Url.of(VALID_URL).getValue()).isEqualTo(VALID_URL);
    }

    @Test
    void shouldRejectInvalidTooLongUrl() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Url.of(INVALID_TOO_LONG_URL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUrl.class)
                .hasMessage("Url [%s] is not valid", INVALID_TOO_LONG_URL);
    }

    @Test
    void shouldRejectEmptyUrl() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Url.of(INVALID_EMPTY_URL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidUrl.class)
                .hasMessage("Url [%s] is not valid", INVALID_EMPTY_URL);
    }
}
