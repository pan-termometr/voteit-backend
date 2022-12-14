package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT user FROM User user WHERE LOWER(user.username) = LOWER(:username)")
    Optional<UserEntity> findByUsername(@Param("username") String username);

    @Query(value = "SELECT user FROM User user WHERE LOWER(user.email) = LOWER(:email)")
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
