package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@JsonInclude(NON_EMPTY)
public class UserResource {

    private final String username;
    private final String email;
    private final LocalDateTime registrationDate;
}
