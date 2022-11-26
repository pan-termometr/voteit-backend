package pl.maciejbadziak.voteitbackend.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.user.domain.error.InvalidUsername;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Username {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.{1,30}$)(?![_.])(?!.*[_.]{2})[a-z0-9._]+(?<![_.])$");

    String value;

    public static Username of(final String value) {
        validate(value);
        return new Username(value);
    }

    private static void validate(final String value) {
        if (!USERNAME_PATTERN.matcher(value).matches()) {
            throw new InvalidUsername(value);
        }
    }
}
