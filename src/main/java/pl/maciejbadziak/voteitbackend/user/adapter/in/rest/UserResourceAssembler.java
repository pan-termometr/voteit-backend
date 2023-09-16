package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import java.util.List;

@Component
public class UserResourceAssembler {

    public List<UserResource> assemble(final List<User> users) {
        return users.stream()
                .map(this::assemble)
                .toList();
    }

    public UserResource assemble(final User user) {
        if (user == null) {
            return null;
        }
        return UserResource.builder()
                .username(user.getUsername().getValue())
                .email(user.getEmail().getValue())
                .registrationDate(user.getRegistrationDate().getValue())
                .build();
    }
}
