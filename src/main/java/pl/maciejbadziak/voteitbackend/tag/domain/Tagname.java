package pl.maciejbadziak.voteitbackend.tag.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.tag.adapter.in.rest.error.InvalidTagnameException;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Tagname {

    private static final Pattern TAGNAME_PATTERN = Pattern.compile("^[a-z\\d-]{1,30}+$");

    String value;

    public static Tagname of(final String value) {
        validate(value);
        return new Tagname(value);
    }

    private static void validate(final String value) {
        if (!TAGNAME_PATTERN.matcher(value).matches()) {
            throw new InvalidTagnameException(value);
        }
    }

}
