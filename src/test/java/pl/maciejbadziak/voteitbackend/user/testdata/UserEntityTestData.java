package pl.maciejbadziak.voteitbackend.user.testdata;

import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;

public class UserEntityTestData {

    public static UserEntity termometrUser() {
        return UserEntity.builder()
                .id(1L)
                .username("termometr")
                .password("password")
                .email("termometr@voteit.com")
                .build();
    }
}
