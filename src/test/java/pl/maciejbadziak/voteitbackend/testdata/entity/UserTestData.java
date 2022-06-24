package pl.maciejbadziak.voteitbackend.testdata.entity;

import pl.maciejbadziak.voteitbackend.entity.User;

public class UserTestData {

    public static User getAdminUser() {
        return User.builder()
                .id(1L)
                .username("admin")
                .password("password")
                .email("admin@voteit.com")
                .build();
    }

    public static User getRandomUser() {
        return User.builder()
                .id(2L)
                .username("random")
                .password("random-pass")
                .email("random@voteit.com")
                .build();
    }
}
