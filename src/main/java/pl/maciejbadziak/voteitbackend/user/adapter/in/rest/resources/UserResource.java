package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator.PasswordMatches;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.validator.ValidEmail;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@JsonInclude(NON_EMPTY)
@PasswordMatches
public class UserResource {

    @NotNull
    @NotEmpty
    private final String username;

    @NotNull
    @NotEmpty
    private final String password;

    @ValidEmail
    @NotNull
    @NotEmpty
    private final String email;

    private final LocalDateTime registrationDate;
}
