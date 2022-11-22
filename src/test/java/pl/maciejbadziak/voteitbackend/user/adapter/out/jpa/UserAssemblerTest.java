package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.testUserEntity;

class UserAssemblerTest {

    @Test
    void shouldAssemblerUser() {
        // given
        final UserEntity userEntity = testUserEntity();

        // when
        final User result = new UserAssembler().assemble(userEntity);

        // then
        assertThat(result).extracting(
                user -> user.getUsername().getValue(),
                user -> user.getEmail().getValue(),
                user -> user.getRegistrationDate().getValue()
        ).containsExactly(
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getRegistrationDate()
        );
    }

    @Test
    void shouldAssembleUsers() {
        // given
        final List<UserEntity> userEntities = of(termometrUserEntity(), testUserEntity());

        // when
        final List<User> result = new UserAssembler().assemble(userEntities);

        // then
        assertThat(result).hasSameSizeAs(userEntities);
    }

    @Test
    void shouldReturnNullFOrNullableEntity() {
        // given
        // when
        final User result = new UserAssembler().assemble((UserEntity) null);

        // then
        assertThat(result).isNull();
    }
}
