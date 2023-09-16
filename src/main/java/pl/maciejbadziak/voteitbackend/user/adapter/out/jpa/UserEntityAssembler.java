package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.User;

@Component
public class UserEntityAssembler {

    public UserEntity assemble(final User user) {
        return UserEntity.builder()
                .username(user.getUsername().getValue())
                .password(user.getPassword())
                .email(user.getEmail().getValue())
                .registrationDate(user.getRegistrationDate().getValue())
                .build();
    }
}
