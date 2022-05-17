package pl.maciejbadziak.voteitbackend.voteit.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;
import pl.maciejbadziak.voteitbackend.voteit.port.FindAllVoteitsPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllVoteitsUseCase {

    private final FindAllVoteitsPort findAllVoteitsPort;

    public List<Voteit> allVoteits() {
        return findAllVoteitsPort.findAll();
    }
}
