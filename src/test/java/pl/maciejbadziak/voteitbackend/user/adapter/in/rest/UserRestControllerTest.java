package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.error.InvalidRequestException;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.usecase.FindUserByUsernameUseCase;

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

    @Mock
    private transient FindUserByUsernameUseCase findUserByUsernameUseCaseMock;

    @Mock
    private transient UserResourceAssembler userResourceAssemblerMock;

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
}
