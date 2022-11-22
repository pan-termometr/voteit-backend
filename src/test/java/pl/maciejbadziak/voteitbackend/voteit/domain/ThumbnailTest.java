package pl.maciejbadziak.voteitbackend.voteit.domain;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidThumbnail;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ThumbnailTest {

    private static final String VALID_THUMBNAIL_URL = "https://valid-thumbnail.com";
    private static final String VALID_THUMBNAIL_PATH = "/voteit-1.jpg";
    private static final String VALID_EMPTY_THUMBNAIL = "";
    private static final String EXCEPTION_MESSAGE = "Thumbnail [%s] is not valid";
    private static final int HTTPS_LENGTH = 8;
    private static final int PL_LENGTH = 3;
    private static final int MAX_LENGTH = 2048 - HTTPS_LENGTH - PL_LENGTH;
    private static final String INVALID_TOO_LONG_THUMBNAIL = generateTooLongThumbnail();

    private static String generateTooLongThumbnail() {
        String domain = IntStream.range(0, MAX_LENGTH)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
        return "https://" + domain + ".pl";
    }

    @Test
    void shouldCreateValidThumbnail() {
        // given
        // when
        // then
        assertThat(Thumbnail.of(VALID_THUMBNAIL_URL).getValue()).isEqualTo(VALID_THUMBNAIL_URL);
    }

    @Test
    void shouldCreateValidThumbnailPath() {
        // given
        // when
        // then
        assertThat(Thumbnail.of(VALID_THUMBNAIL_PATH).getValue()).isEqualTo(VALID_THUMBNAIL_PATH);
    }

    @Test
    void shouldCreateThumbnailWhenEmpty() {
        // given
        // when
        // then
        assertThat(Thumbnail.of(VALID_EMPTY_THUMBNAIL).getValue()).isEqualTo(VALID_EMPTY_THUMBNAIL);
    }

    @Test
    void shouldRejectInvalidTooLongThumbnail() {
        // given
        // when
        final Throwable result = catchThrowable(() -> Thumbnail.of(INVALID_TOO_LONG_THUMBNAIL));

        // then
        assertThat(result)
                .isInstanceOf(InvalidThumbnail.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_THUMBNAIL);
    }
}
