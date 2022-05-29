package pl.maciejbadziak.voteitbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.maciejbadziak.voteitbackend.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
