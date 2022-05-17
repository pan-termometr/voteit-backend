package pl.maciejbadziak.voteitbackend.user.testdata;

import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;

import java.time.LocalDateTime;

public class UserEntityTestData {

    public static UserEntity termometrUser() {
        return UserEntity.builder()
                .id(1L)
                .username("termometr")
                .password("password")
                .email("termometr@voteit.com")
                .registrationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }
}
