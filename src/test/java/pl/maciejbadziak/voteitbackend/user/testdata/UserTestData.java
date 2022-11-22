package pl.maciejbadziak.voteitbackend.user.testdata;

import pl.maciejbadziak.voteitbackend.user.domain.Email;
import pl.maciejbadziak.voteitbackend.user.domain.RegistrationDate;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.domain.Username;

import java.time.LocalDateTime;

public class UserTestData {

    public static User termometrUser() {
        return User.builder()
                .username(Username.of("termometr"))
                .email(Email.of("termometr@test.pl"))
                .registrationDate(RegistrationDate.of(LocalDateTime.of(2022, 11, 11, 13, 13, 13)))
                .build();
    }

    public static User testUser() {
        return User.builder()
                .username(Username.of("test"))
                .email(Email.of("test@voteit.com"))
                .registrationDate(RegistrationDate.of(LocalDateTime.of(2022, 11, 11, 13, 13, 13)))
                .build();
    }
}
