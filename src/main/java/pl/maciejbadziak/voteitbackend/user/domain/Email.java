package pl.maciejbadziak.voteitbackend.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.maciejbadziak.voteitbackend.user.domain.error.InvalidEmail;

import java.util.regex.Pattern;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-zA-Z\\d_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z\\d.-]*).{6,320}$");

    String value;

    public static Email of(final String value) {
        validate(value);
        return new Email(value);
    }

    private static void validate(final String value) {
        if (!EMAIL_PATTERN.matcher(value).matches() || !containsDotInDomain(value)) {
            throw new InvalidEmail(value);
        }
    }

    private static boolean containsDotInDomain(String value) {
        return value.substring(value.lastIndexOf("@")).contains(".");
    }
}
