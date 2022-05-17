package pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(NON_EMPTY)
public class UserResource {

    private final String username;
    private final String email;
}
