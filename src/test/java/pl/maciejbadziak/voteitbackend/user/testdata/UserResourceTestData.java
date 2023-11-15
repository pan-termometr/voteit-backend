package pl.maciejbadziak.voteitbackend.user.testdata;

import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;

import java.time.LocalDateTime;

public class UserResourceTestData {

    public static UserResource termometrUserResource() {
        return UserResource.builder()
                .username("termometr")
                .email("termometr@voteit.com")
                .registrationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }

    public static UserResource testUserResource() {
        return UserResource.builder()
                .username("test")
                .email("test@voteit.com")
                .registrationDate(LocalDateTime.of(2022, 11, 11, 13, 13, 13))
                .build();
    }

    public static UserResource testUserToBeRegisteredResource() {
        return UserResource.builder()
                .username("test")
                .password("test-password")
                .email("test@voteit.com")
                .registrationDate(null)
                .build();
    }
}
