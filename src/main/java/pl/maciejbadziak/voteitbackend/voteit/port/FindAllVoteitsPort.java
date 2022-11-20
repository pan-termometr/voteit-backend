package pl.maciejbadziak.voteitbackend.voteit.port;

import pl.maciejbadziak.voteitbackend.voteit.domain.Voteit;

import java.util.List;

public interface FindAllVoteitsPort {

    List<Voteit> findAll();
}
