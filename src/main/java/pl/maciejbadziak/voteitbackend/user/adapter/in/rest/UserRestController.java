package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.error.InvalidRequestException;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.usecase.FindByUsernameUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserRestController {

    private final FindByUsernameUseCase findByUsernameUseCase;

    private final UserResourceAssembler assembler;

    private static void validateRequest(final String username) {
        if(isUsernameInvalid(username)) {
            throw new InvalidRequestException(username);
        }
    }

    private static boolean isUsernameInvalid(final String username) {
        return username.isBlank() || username.length() >= 30;
    }

    @GetMapping(
            path = "/{username}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserResource userById(@PathVariable final String username) {
        validateRequest(username);
        return assembler.assemble(findByUsernameUseCase.find(username));
    }

}
