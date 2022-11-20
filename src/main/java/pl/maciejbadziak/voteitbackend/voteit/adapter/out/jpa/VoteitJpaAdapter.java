package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;
import pl.maciejbadziak.voteitbackend.voteit.port.FindAllVoteitsPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VoteitJpaAdapter implements FindAllVoteitsPort {

    private final VoteitRepository repository;

    private final VoteitAssembler assembler;

    @Transactional
    @Override
    public List<Voteit> findAll() {
        final List<VoteitEntity> voteitEntities = repository.findAll();
        return assembler.assemble(voteitEntities);
    }
}
