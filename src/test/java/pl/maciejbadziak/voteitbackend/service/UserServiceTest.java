package pl.maciejbadziak.voteitbackend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.entity.User;
import pl.maciejbadziak.voteitbackend.mapper.UserMapper;
import pl.maciejbadziak.voteitbackend.repository.UserRepository;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.maciejbadziak.voteitbackend.testdata.dto.UserDtoTestData.getAdminUserDto;
import static pl.maciejbadziak.voteitbackend.testdata.dto.UserDtoTestData.getRandomUserDto;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getAdminUser;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getRandomUser;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {UserService.class})
class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private UserMapper userMapperMock;
    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnAllUsers() {
        // given
        Set<User> users = Set.of(getAdminUser(), getRandomUser());
        List<UserDto> userDtos = List.of(getAdminUserDto(), getRandomUserDto());
        when(userRepositoryMock.findAll()).thenReturn(users);
        when(userMapperMock.usersToUserDtos(users)).thenReturn(userDtos);

        // when
        List<UserDto> result = userService.getAll();

        // then
        assertEquals(userDtos, result);
        verify(userRepositoryMock, times(1)).findAll();
        verify(userMapperMock, times(1)).usersToUserDtos(users);
    }
}
