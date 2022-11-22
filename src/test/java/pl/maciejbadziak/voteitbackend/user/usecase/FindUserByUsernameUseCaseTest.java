package pl.maciejbadziak.voteitbackend.user.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByUsernamePort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

@ExtendWith(MockitoExtension.class)
class FindUserByUsernameUseCaseTest {

    @Mock
    private transient FindUserByUsernamePort findUserByUsernamePortMock;

    @InjectMocks
    private transient FindUserByUsernameUseCase findUserByUsernameUseCase;

    @Test
    void shouldProvideUserByUsername() {
        // given
        final User user = testUser();

        when(findUserByUsernamePortMock.findByUsername(user.getUsername().getValue())).thenReturn(user);

        // when
        final User result = findUserByUsernameUseCase.find(user.getUsername().getValue());

        // then
        assertThat(result).isEqualTo(user);
    }
}
