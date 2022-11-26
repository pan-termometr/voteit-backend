package pl.maciejbadziak.voteitbackend.user.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class User {

    private final Username username;
    private final Email email;
    private final RegistrationDate registrationDate;
}
