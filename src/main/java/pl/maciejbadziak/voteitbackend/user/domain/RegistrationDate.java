package pl.maciejbadziak.voteitbackend.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegistrationDate {

    LocalDateTime value;

    public static RegistrationDate of(final LocalDateTime value) {
        return new RegistrationDate(value);
    }

}
