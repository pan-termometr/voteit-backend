package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.error.InvalidRequestException;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.usecase.FindUserByUsernameUseCase;
import pl.maciejbadziak.voteitbackend.user.usecase.RegisterNewUserUseCase;
import pl.maciejbadziak.voteitbackend.user.usecase.error.UserAlreadyExistsException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserResourceTestData.testUserResource;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserTestData.testUser;

@ExtendWith(MockitoExtension.class)
class UserRestControllerTest {

    private static final String INVALID_EMPTY_REQUEST = "";
    private static final int MAX_LENGTH = 30;
    private static final String INVALID_TOO_LONG_REQUEST = generateTooLongRequest();
    private static final String EXCEPTION_MESSAGE = "Requested user: [%s] is not valid ";
    private static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "User with this username (%s) already exists.";
    private static final String SUCCESSFULLY_REGISTERED_MESSAGE = "Hey %s, you are successfully registered!";

    @Mock
    private transient FindUserByUsernameUseCase findUserByUsernameUseCaseMock;

    @Mock
    private transient UserResourceAssembler userResourceAssemblerMock;

    @Mock
    private transient UserInAssembler userInAssemblerMock;

    @Mock
    private transient RegisterNewUserUseCase registerNewUserUseCaseMock;

    @InjectMocks
    private transient UserRestController userRestController;

    private static String generateTooLongRequest() {
        return IntStream.range(0, MAX_LENGTH + 1)
                .mapToObj(i -> "x")
                .collect(Collectors.joining(""));
    }

    @Test
    void shouldProvideUserByUsername() {
        // given
        final User user = testUser();
        final UserResource userResource = testUserResource();

        when(findUserByUsernameUseCaseMock.find(user.getUsername().getValue())).thenReturn(user);
        when(userResourceAssemblerMock.assemble(user)).thenReturn(userResource);

        // when
        final UserResource result = userRestController.userByUsername(user.getUsername().getValue());

        // then
        assertThat(result).isEqualTo(userResource);
        verify(findUserByUsernameUseCaseMock, times(1)).find(user.getUsername().getValue());
        verify(userResourceAssemblerMock, times(1)).assemble(user);
    }

    @Test
    void shouldThrowExceptionForEmptyRequest() {
        // given
        // when
        final Throwable result = catchThrowable(() -> userRestController.userByUsername(INVALID_EMPTY_REQUEST));

        // then
        assertThat(result)
                .isInstanceOf(InvalidRequestException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_EMPTY_REQUEST);
    }

    @Test
    void shouldThrowExceptionForTooLongRequest() {
        // given
        // when
        final Throwable result = catchThrowable(() -> userRestController.userByUsername(INVALID_TOO_LONG_REQUEST));

        // then
        assertThat(result)
                .isInstanceOf(InvalidRequestException.class)
                .hasMessage(EXCEPTION_MESSAGE, INVALID_TOO_LONG_REQUEST);
    }

    @Test
    void shouldProvideSuccessfulResponseEntityTest() throws UserAlreadyExistsException {
        // given
        final UserResource userResource = testUserResource();
        final User user = testUser();

        when(userInAssemblerMock.assemble(userResource)).thenReturn(user);
        when(registerNewUserUseCaseMock.register(user)).thenReturn(user);
        when(userResourceAssemblerMock.assemble(user)).thenReturn(userResource);

        // when
        final ResponseEntity<Object> response = userRestController.registerUser(userResource);

        // then
        assertThat(response).extracting(
                ResponseEntity::getStatusCode,
                HttpEntity::getBody
        ).containsExactly(
                HttpStatus.CREATED,
                String.format(SUCCESSFULLY_REGISTERED_MESSAGE, user.getUsername().getValue())
        );
    }

    @Test
    void shouldProvideConflictResponseEntityForUserAlreadyExistsExceptionTest() throws UserAlreadyExistsException {
        // given
        final UserResource userResource = testUserResource();
        final User user = testUser();
        final String exceptionMessage = String.format(USER_ALREADY_EXISTS_EXCEPTION_MESSAGE, userResource.getUsername());

        when(userInAssemblerMock.assemble(userResource)).thenReturn(user);
        when(registerNewUserUseCaseMock.register(user)).thenThrow(new UserAlreadyExistsException(exceptionMessage));

        // when
        final ResponseEntity<Object> response = userRestController.registerUser(userResource);

        // then
        assertThat(response).extracting(
                ResponseEntity::getStatusCode,
                HttpEntity::getBody
        ).containsExactly(
                HttpStatus.CONFLICT,
                exceptionMessage
        );
    }
}
