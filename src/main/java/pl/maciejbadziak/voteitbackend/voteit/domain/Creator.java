package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidCreator;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Creator {

    private static final Pattern CREATOR_PATTERN = Pattern.compile("^(?=.{1,30}$)(?![_.])(?!.*[_.]{2})[a-z\\d._]+(?<![_.])$");

    String value;

    public static Creator of(final String value) {
        validate(value);
        return new Creator(value);
    }

    private static void validate(final String value) {
        if (!CREATOR_PATTERN.matcher(value).matches()) {
            throw new InvalidCreator(value);
        }
    }
}
