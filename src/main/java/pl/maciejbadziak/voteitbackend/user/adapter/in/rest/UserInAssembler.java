package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.Email;
import pl.maciejbadziak.voteitbackend.user.domain.RegistrationDate;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.domain.Username;

import static java.time.LocalDateTime.now;

@Component
@AllArgsConstructor
public class UserInAssembler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User assemble(final UserResource userResource) {
        return User.builder()
                .username(Username.of(userResource.getUsername()))
                .password(passwordEncoder.encode(userResource.getPassword()))
                .email(Email.of(userResource.getEmail()))
                .registrationDate(RegistrationDate.of(now()))
                .build();
    }
}
