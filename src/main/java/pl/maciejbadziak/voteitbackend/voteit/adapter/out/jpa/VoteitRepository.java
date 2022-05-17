package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteitRepository extends JpaRepository<VoteitEntity, Long> {
}
