package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByUsernamePort;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements FindUserByUsernamePort {

    private final UserRepository repository;

    private final UserAssembler assembler;

    @Transactional
    @Override
    public User findByUsername(final String username) {
        return assembler.assemble(repository.findByUsername(username).orElse(null));
    }
}
