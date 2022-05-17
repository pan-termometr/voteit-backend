package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidThumbnail;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Thumbnail {

    private static final Pattern THUMBNAIL_URL_PATTERN = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=].{1,2035}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&/=]*){2048}$");
    private static final Pattern THUMBNAIL_PATH_PATTERN = Pattern.compile("^(.*/)([^/]*){18}$");

    String value;

    public static Thumbnail of(final String value) {
        validate(value);
        return new Thumbnail(value);
    }

    private static void validate(final String value) {
        if (isWrongUrl(value) || isWrongPath(value)) {
            throw new InvalidThumbnail(value);
        }
    }

    private static boolean isWrongUrl(final String value) {
        return !value.isBlank() && !THUMBNAIL_URL_PATTERN.matcher(value).matches() && !value.startsWith("/voteit-");
    }

    private static boolean isWrongPath(final String value) {
        return !value.isBlank() &&
                !THUMBNAIL_PATH_PATTERN.matcher(value).matches() &&
                value.startsWith("/voteit-");
    }
}
