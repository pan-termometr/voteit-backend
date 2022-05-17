package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidTag;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Tag {

    private static final Pattern TAG_PATTERN = Pattern.compile("^[a-z]{1,10}+$");

    String value;

    public static Tag of(final String value) {
        validate(value);
        return new Tag(value);
    }

    private static void validate(final String value) {
        if (!TAG_PATTERN.matcher(value).matches()) {
            throw new InvalidTag(value);
        }
    }
}
