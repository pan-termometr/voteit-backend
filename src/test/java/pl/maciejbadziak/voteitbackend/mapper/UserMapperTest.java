package pl.maciejbadziak.voteitbackend.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.entity.User;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static pl.maciejbadziak.voteitbackend.asserts.UserDtoAssert.assertThat;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getAdminUser;
import static pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData.getRandomUser;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserMapperImpl.class)
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void shouldMapToNullForNullUser() {
        // given
        // when
        UserDto result = userMapper.userToUserDto(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldMapUserToUserDto() {
        // given
        User user = getAdminUser();

        // when
        UserDto result = userMapper.userToUserDto(user);

        // then
        assertEquals(user.getId(), result.getId());
        assertThat(result)
                .hasId(user.getId())
                .hasUsername(user.getUsername())
                .hasEmail(user.getEmail());
    }

    @Test
    void shouldMapToNullForNullUsers() {
        // given
        // when
        List<UserDto> result = userMapper.usersToUserDtos(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldMapUsersToUserDtos() {
        // given
        Set<User> users = Set.of(getAdminUser(), getRandomUser());

        // when
        List<UserDto> result = userMapper.usersToUserDtos(users);

        // then
        assertEquals(2, result.size());
    }
}