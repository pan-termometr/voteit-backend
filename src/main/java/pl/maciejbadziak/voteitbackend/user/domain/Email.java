package pl.maciejbadziak.voteitbackend.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.voteit.domain.error.InvalidCreator;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Email {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n");

    String value;

    public static Email of(final String value) {
        validate(value);
        return new Email(value);
    }

    private static void validate(final String value) {
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new InvalidCreator(value);
        }
    }
}
