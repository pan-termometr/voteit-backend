package pl.maciejbadziak.voteitbackend.user.adapter.in.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.error.InvalidRequestException;
import pl.maciejbadziak.voteitbackend.user.adapter.in.rest.resources.UserResource;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.usecase.FindUserByUsernameUseCase;
import pl.maciejbadziak.voteitbackend.user.usecase.RegisterNewUserUseCase;
import pl.maciejbadziak.voteitbackend.user.usecase.error.UserAlreadyExistsException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserRestController {

    private static final int USERNAME_MAX_LENGTH = 30;

    private final FindUserByUsernameUseCase findUserByUsernameUseCase;

    private final RegisterNewUserUseCase registerNewUserUseCase;

    private final UserResourceAssembler userResourceAssembler;

    private final UserAssembler userAssembler;

    @GetMapping(
            path = "/{username}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserResource userByUsername(@PathVariable final String username) throws InvalidRequestException {
        validateUsername(username);
        return userResourceAssembler.assemble(findUserByUsernameUseCase.find(username));
    }

    @PostMapping("/registration")
    public UserResource registerUser(@RequestBody @Valid UserResource userResource) throws UserAlreadyExistsException {
        final User user = userAssembler.assemble(userResource);
        return userResourceAssembler.assemble(registerNewUserUseCase.register(user));
    }

    private static void validateUsername(final String username) throws InvalidRequestException {
        if(isUsernameInvalid(username)) {
            throw new InvalidRequestException(username);
        }
    }

    private static boolean isUsernameInvalid(final String username) {
        return username.isBlank() || username.length() >= USERNAME_MAX_LENGTH;
    }
}
