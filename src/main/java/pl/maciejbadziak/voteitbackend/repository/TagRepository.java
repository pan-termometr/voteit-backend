package pl.maciejbadziak.voteitbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maciejbadziak.voteitbackend.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
