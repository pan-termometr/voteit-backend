package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidTitleException;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Title {

    private static final Pattern TITLE_PATTERN = Pattern.compile("^.{1,80}$");

    String value;

    public static Title of(final String value) {
        validate(value);
        return new Title(value);
    }

    private static void validate(final String value) {
        if (!TITLE_PATTERN.matcher(value).matches()) {
            throw new InvalidTitleException(value);
        }
    }
}
