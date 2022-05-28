package pl.maciejbadziak.voteitbackend.mapper;

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
    public void shouldMapUserToUserDto() {
        // given
        User user = UserTestData.getAdminUser();

        // when
        UserDto userDto = userMapper.userToUserDto(user);

        // then
        UserDtoAssert.assertThat(userDto)
                .hasUsername(user.getUsername())
                .hasEmail(user.getEmail())
                .hasOnlyVoteits(user.getVoteits());
    }
}