package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

class UserEntityAssemblerTest {

    @Test
    void shouldAssembleUserEntityTest() {
        // given
        final User user = testUser();

        // when
        final UserEntity result = new UserEntityAssembler().assemble(user);

        // then
        Assertions.assertThat(result).extracting(
                UserEntity::getUsername,
                UserEntity::getPassword,
                UserEntity::getEmail,
                UserEntity::getRegistrationDate
        ).containsExactly(
                result.getUsername(),
                result.getPassword(),
                result.getEmail(),
                result.getRegistrationDate()
        );
    }
}
