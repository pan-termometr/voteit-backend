package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.Email;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.domain.Username;

@Component
public class UserAssembler {

    public User assemble(final UserResource userResource) {
        return User.builder()
                .username(Username.of(userResource.getUsername()))
                .password(userResource.getPassword())
                .matchingPassword(userResource.getMatchingPassword())
                .email(Email.of(userResource.getEmail()))
                .build();
    }
}
