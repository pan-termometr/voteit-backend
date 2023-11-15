package pl.maciejbadziak.voteitbackend.user.usecase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.RegisterNewUserPort;
import pl.maciejbadziak.voteitbackend.user.usecase.error.UserAlreadyExistsException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testRegisteredUser;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

@ExtendWith(MockitoExtension.class)
class RegisterNewUserUseCaseTest {

    private static final String EMAIL_EXCEPTION_MESSAGE = "User with this email (%s) already exists.";
    private static final String USERNAME_EXCEPTION_MESSAGE = "User with this username (%s) already exists.";

    @Mock
    private transient FindUserByUsernameUseCase findUserByUsernameUseCaseMock;

    @Mock
    private transient FindUserByEmailUseCase findUserByEmailUseCaseMock;

    @Mock
    private transient RegisterNewUserPort registerNewUserPortMock;

    @InjectMocks
    private transient RegisterNewUserUseCase registerNewUserUseCase;

    @Test
    void shouldRegisterNewUser() throws UserAlreadyExistsException {
        // given
        final User user = testUser();
        final User registeredUser = testRegisteredUser();

        when(findUserByEmailUseCaseMock.find(user.getEmail().getValue())).thenReturn(null);
        when(findUserByUsernameUseCaseMock.find(user.getUsername().getValue())).thenReturn(null);
        when(registerNewUserPortMock.registerNewUser(user)).thenReturn(registeredUser);

        // when
        final User result = registerNewUserUseCase.register(user);

        // then
        assertThat(result).extracting(
                usr -> usr.getUsername().getValue(),
                usr -> usr.getEmail().getValue(),
                usr -> usr.getRegistrationDate().getValue()
        ).containsExactly(
                registeredUser.getUsername().getValue(),
                registeredUser.getEmail().getValue(),
                registeredUser.getRegistrationDate().getValue()
        );
    }

    @Test
    void shouldThrowUserAlreadyExistExceptionForUserWithAlreadyRegisteredEmail() {
        // given
        final User user = testUser();

        when(findUserByEmailUseCaseMock.find(user.getEmail().getValue())).thenReturn(user);

        // when
        final Throwable result = catchThrowable(() -> registerNewUserUseCase.register(user));

        // then
        assertThat(result)
                .isInstanceOf(UserAlreadyExistsException.class)
                .hasMessage(EMAIL_EXCEPTION_MESSAGE, user.getEmail().getValue());
    }

    @Test
    void shouldThrowUserAlreadyExistExceptionForUserWithAlreadyRegisteredUsername() {
        // given
        final User user = testUser();

        when(findUserByEmailUseCaseMock.find(user.getEmail().getValue())).thenReturn(null);
        when(findUserByUsernameUseCaseMock.find(user.getUsername().getValue())).thenReturn(user);

        // when
        final Throwable result = catchThrowable(() -> registerNewUserUseCase.register(user));

        // then
        assertThat(result)
                .isInstanceOf(UserAlreadyExistsException.class)
                .hasMessage(USERNAME_EXCEPTION_MESSAGE, user.getUsername().getValue());
    }
}
