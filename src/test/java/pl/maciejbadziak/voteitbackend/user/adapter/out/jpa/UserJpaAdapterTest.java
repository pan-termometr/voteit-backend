package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserEntityTestData.testUserEntity;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

@ExtendWith(MockitoExtension.class)
class UserJpaAdapterTest {

    @Mock
    private transient UserRepository userRepositoryMock;

    @Mock
    private transient UserAssembler userAssemblerMock;

    @Mock
    private transient UserEntityAssembler userEntityAssemblerMock;

    @InjectMocks
    private transient UserJpaAdapter userJpaAdapter;

    @Test
    void shouldProvideUserByUsername() {
        // given
        final UserEntity givenUserEntity = testUserEntity();
        final User expectedUser = testUser();

        when(userRepositoryMock.findByUsername(givenUserEntity.getUsername())).thenReturn(Optional.of(givenUserEntity));
        when(userAssemblerMock.assemble(givenUserEntity)).thenReturn(expectedUser);

        // when
        final User result = userJpaAdapter.findByUsername(givenUserEntity.getUsername());

        // then
        assertThat(result).isEqualTo(expectedUser);
        verify(userRepositoryMock, times(1)).findByUsername(givenUserEntity.getUsername());
        verify(userAssemblerMock, times(1)).assemble(givenUserEntity);
    }

    @Test
    void shouldProvideUserByEmail() {
        // given
        final UserEntity givenUserEntity = testUserEntity();
        final User expectedUser = testUser();

        when(userRepositoryMock.findByEmail(givenUserEntity.getEmail())).thenReturn(Optional.of(givenUserEntity));
        when(userAssemblerMock.assemble(givenUserEntity)).thenReturn(expectedUser);

        // when
        final User result = userJpaAdapter.findByEmail(givenUserEntity.getEmail());

        // then
        assertThat(result).isEqualTo(expectedUser);
        verify(userRepositoryMock, times(1)).findByEmail(givenUserEntity.getEmail());
        verify(userAssemblerMock, times(1)).assemble(givenUserEntity);
    }

    @Test
    void shouldProvideRegisteredNewUser() {
        // given
        final UserEntity userEntity = testUserEntity();
        final User user = testUser();

        when(userEntityAssemblerMock.assemble(user)).thenReturn(userEntity);
        when(userRepositoryMock.save(userEntity)).thenReturn(userEntity);
        when(userAssemblerMock.assemble(userEntity)).thenReturn(user);

        // when
        final User result = userJpaAdapter.registerNewUser(user);

        // then
        assertThat(result).isEqualTo(user);
        verify(userEntityAssemblerMock, times(1)).assemble(user);
        verify(userRepositoryMock, times(1)).save(userEntity);
    }
}
