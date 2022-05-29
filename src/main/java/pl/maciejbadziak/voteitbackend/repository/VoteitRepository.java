package pl.maciejbadziak.voteitbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maciejbadziak.voteitbackend.entity.Voteit;

@Repository
public interface VoteitRepository extends CrudRepository<Voteit, Long> {
}
