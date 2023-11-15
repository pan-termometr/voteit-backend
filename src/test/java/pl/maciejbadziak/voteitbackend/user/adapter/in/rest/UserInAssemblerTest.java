package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.Mockito.when;
import static pl.maciejbadziak.voteitbackend.user.testdata.UserResourceTestData.testUserResource;

@ExtendWith(MockitoExtension.class)
class UserInAssemblerTest {

    private static final String ENCODED_PASSWORD = "ENCODED PASSWORD";
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserInAssembler userInAssembler;

    @Test
    void shouldAssemblerUser() {
        // given
        final UserResource userResource = testUserResource();
        when(passwordEncoder.encode(userResource.getPassword())).thenReturn(ENCODED_PASSWORD);

        // when
        final User result = userInAssembler.assemble(userResource);

        // then
        assertThat(result).extracting(
                user -> user.getUsername().getValue(),
                user -> user.getEmail().getValue(),
                User::getPassword
        ).containsExactly(
                userResource.getUsername(),
                userResource.getEmail(),
                ENCODED_PASSWORD
        );
        assertThat(result.getRegistrationDate().getValue())
                .isCloseTo(LocalDateTime.now(), within(1000, ChronoUnit.MILLIS));
    }
}
