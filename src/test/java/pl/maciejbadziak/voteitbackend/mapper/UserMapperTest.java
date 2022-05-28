package pl.maciejbadziak.voteitbackend.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.maciejbadziak.voteitbackend.dto.UserDto;
import pl.maciejbadziak.voteitbackend.dto.UserDtoAssert;
import pl.maciejbadziak.voteitbackend.entity.User;
import pl.maciejbadziak.voteitbackend.testdata.entity.UserTestData;

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
        Assertions.assertNull(result);
    }

    @Test
    void shouldMapUserToUserDto() {
        // given
        User user = UserTestData.getAdminUser();

        // when
        UserDto result = userMapper.userToUserDto(user);

        // then
        Assertions.assertEquals(user.getId(), result.getId());
        UserDtoAssert.assertThat(result)
                .hasUsername(user.getUsername())
                .hasEmail(user.getEmail())
                .hasOnlyVoteits(user.getVoteits());
    }
}