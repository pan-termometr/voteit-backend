package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.maciejbadziak.voteitbackend.IntegrationTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.termometrUserEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.testUserEntity;

class UserRepositoryTest extends IntegrationTest {

    @Autowired
    private transient UserRepository userRepository;

    @BeforeEach
    public void init() {
        userRepository.deleteAll();
    }

    @Test
    void shouldReturnUserByUsername() {
        // given
        final UserEntity termometrUserEntity = termometrUserEntity();
        final UserEntity testUserEntity = testUserEntity();

        userRepository.saveAll(List.of(termometrUserEntity, testUserEntity));

        // when
        final Optional<UserEntity> result = userRepository.findByUsername(termometrUserEntity.getUsername());

        // then
        assertThat(result).isPresent();
        assertThat(result.get()).extracting(
                UserEntity::getUsername,
                UserEntity::getPassword,
                UserEntity::getEmail,
                UserEntity::getRegistrationDate
        ).containsExactly(
                termometrUserEntity.getUsername(),
                termometrUserEntity.getPassword(),
                termometrUserEntity.getEmail(),
                termometrUserEntity.getRegistrationDate()
        );
    }

    @Test
    void shouldReturnEmptyOptionalForNonExistingUsername() {
        // given
        // when
        final Optional<UserEntity> result = userRepository.findByUsername("nonexistingusername");

        // then
        assertThat(result).isEmpty();
    }
}
