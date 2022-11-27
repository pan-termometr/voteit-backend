package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidDescriptionException;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Description {

    private static final Pattern DESCRIPTION_PATTERN = Pattern.compile("^.{1,300}$");

    String value;

    public static Description of(final String value) {
        validate(value);
        return new Description(value);
    }

    private static void validate(final String value) {
        if (!DESCRIPTION_PATTERN.matcher(value).matches()) {
            throw new InvalidDescriptionException(value);
        }
    }
}
