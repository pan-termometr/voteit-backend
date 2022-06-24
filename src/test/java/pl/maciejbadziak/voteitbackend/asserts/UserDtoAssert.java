package pl.maciejbadziak.voteitbackend.asserts;

import org.assertj.core.api.AbstractAssert;
import pl.maciejbadziak.voteitbackend.dto.UserDto;

public class UserDtoAssert extends AbstractAssert<UserDtoAssert, UserDto> {

    public UserDtoAssert(UserDto actual) {
        super(actual, UserDtoAssert.class);
    }

    public static UserDtoAssert assertThat(UserDto actual) {
        return new UserDtoAssert(actual);
    }

    public UserDtoAssert hasId(Long id) {
        isNotNull();
        if(!actual.getId().equals(id)) {
            failWithMessage("Expected user to have id %s but was %s.",
                    id,
                    actual.getId());
        }
        return this;
    }

    public UserDtoAssert hasUsername(String username) {
        isNotNull();
        if(!actual.getUsername().equals(username)) {
            failWithMessage("Expected user to have username %s but was %s.",
                    username,
                    actual.getUsername());
        }
        return this;
    }

    public UserDtoAssert hasEmail(String email) {
        isNotNull();
        if(!actual.getEmail().equals(email)) {
            failWithMessage("Expected user to have email %s but was %s.",
                    email,
                    actual.getEmail());
        }
        return this;
    }
}
