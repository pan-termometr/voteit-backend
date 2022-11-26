package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidUrl;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Url {

    private static final Pattern URL_PATTERN = Pattern.compile("https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=].{1,2035}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&/=]*){2048}$");

    String value;

    public static Url of(final String value) {
        validate(value);
        return new Url(value);
    }

    private static void validate(final String value) {
        if (!URL_PATTERN.matcher(value).matches()) {
            throw new InvalidUrl(value);
        }
    }
}
