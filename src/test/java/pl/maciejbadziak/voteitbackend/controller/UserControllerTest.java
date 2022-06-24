package pl.maciejbadziak.voteitbackend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.service.UserService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.testdata.dto.UserDtoTestData.getAdminUserDto;
import static pl.maciejbadziak.voteitbackend.testdata.dto.UserDtoTestData.getRandomUserDto;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {UserController.class})
class UserControllerTest {

    @Mock
    private UserService userServiceMock;
    @InjectMocks
    private UserController userController;

    @Test
    void shouldGetAllUsers() {
        // given
        List<UserDto> userDtos = List.of(getAdminUserDto(), getRandomUserDto());
        when(userServiceMock.getAll()).thenReturn(userDtos);

        // when
        ResponseEntity<List<UserDto>> result = userController.getAllUsers();

        // then
        assertEquals(userDtos, result.getBody());
        verify(userServiceMock, times(1)).getAll();
    }
}
