package pl.maciejbadziak.voteitbackend.voteit.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreationDate {

    LocalDateTime value;

    public static CreationDate of(final LocalDateTime value) {
        return new CreationDate(value);
    }
}
