package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.domain.Email;
import pl.maciejbadziak.voteitbackend.user.domain.RegistrationDate;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.domain.Username;

import java.util.List;

@Component
public class UserAssembler {

    public List<User> assemble(final List<UserEntity> users) {
        return users.stream()
                .map(this::assemble)
                .toList();
    }

    public User assemble(final UserEntity user) {
        if (user == null) {
            return null;
        }
        return User.builder()
                .username(Username.of(user.getUsername()))
                .email(Email.of(user.getEmail()))
                .registrationDate(RegistrationDate.of(user.getRegistrationDate()))
                .build();
    }
}
