package pl.maciejbadziak.voteitbackend.user.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByEmailPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

@ExtendWith(MockitoExtension.class)
class FindUserByEmailUseCaseTest {

    @Mock
    private transient FindUserByEmailPort findUserByEmailPortMock;

    @InjectMocks
    private transient FindUserByEmailUseCase findUserByEmailUseCase;

    @Test
    void shouldProvideUserByEmail() {
        // given
        final User user = testUser();

        when(findUserByEmailPortMock.findByEmail(user.getEmail().getValue())).thenReturn(user);

        // when
        final User result = findUserByEmailUseCase.find(user.getEmail().getValue());

        // then
        assertThat(result).isEqualTo(user);
    }
}
