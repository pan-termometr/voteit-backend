package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejbadziak.voteitbackend.user.domain.User;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByEmailPort;
import pl.maciejbadziak.voteitbackend.user.port.FindUserByUsernamePort;
import pl.maciejbadziak.voteitbackend.user.port.RegisterNewUserPort;

@Component
@RequiredArgsConstructor
public class UserJpaAdapter implements FindUserByUsernamePort, FindUserByEmailPort, RegisterNewUserPort {

    private final UserRepository repository;

    private final UserAssembler assembler;

    private final UserEntityAssembler entityAssembler;

    @Transactional
    @Override
    public User findByUsername(final String username) {
        return assembler.assemble(repository.findByUsername(username).orElse(null));
    }

    @Transactional
    @Override
    public User findByEmail(final String email) {
        return assembler.assemble(repository.findByEmail(email).orElse(null));
    }

    @Transactional
    @Override
    public User registerNewUser(final User user) {
        UserEntity entity = entityAssembler.assemble(user);
        return assembler.assemble(repository.save(entity));
    }
}
