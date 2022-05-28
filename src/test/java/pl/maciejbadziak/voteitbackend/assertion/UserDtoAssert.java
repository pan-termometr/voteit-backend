package pl.maciejbadziak.voteitbackend.assertion;

import org.assertj.core.api.AbstractAssert;
import pl.maciejbadziak.voteitbackend.dto.UserDto;

public class UserDtoAssert extends AbstractAssert<UserDtoAssert, UserDto> {

    public UserDtoAssert(UserDto actual) {
        super(actual, UserDto.class);
    }

    public static UserDtoAssert assertThat(UserDto actual) {
        return new UserDtoAssert(actual);
    }

    public UserDtoAssert hasUsername(String username) {
        isNotNull();
        if (actual.getUsername().equals(username)) {
            failWithMessage("Expected person to have full name %s but was %s",
                    username, actual.getUsername());
        }
        return this;
    }
}
