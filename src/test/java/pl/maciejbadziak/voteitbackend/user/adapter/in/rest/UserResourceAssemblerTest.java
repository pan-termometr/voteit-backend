package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.termometrUser;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

class UserResourceAssemblerTest {

    @Test
    void shouldAssemblerUser() {
        // given
        final User user = termometrUser();

        // when
        final UserResource result = new UserResourceAssembler().assemble(user);

        // then
        assertThat(result).extracting(
                UserResource::getUsername,
                UserResource::getEmail,
                UserResource::getRegistrationDate
        ).containsExactly(
                user.getUsername().getValue(),
                user.getEmail().getValue(),
                user.getRegistrationDate().getValue()
        );
    }

    @Test
    void shouldAssembleUsers() {
        // given
        final List<User> users = of(termometrUser(), testUser());

        // when
        final List<UserResource> result = new UserResourceAssembler().assemble(users);

        // then
        assertThat(result).hasSameSizeAs(users);
    }

    @Test
    void shouldReturnNullForNullableUser() {
        // given
        // when
        final UserResource result = new UserResourceAssembler().assemble((User) null);

        // then
        assertThat(result).isNull();
    }
}
