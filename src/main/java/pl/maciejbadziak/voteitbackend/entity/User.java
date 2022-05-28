package pl.maciejbadziak.voteitbackend.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
@Getter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @OneToMany(mappedBy = "author", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private final Set<Voteit> voteits;
    @Column(length=20, nullable=false)
    private final String username;
    @Column(length=20, nullable=false)
    private final String password;
    @Column(length=30, nullable=false)
    private final String email;
    @Builder
    public User(Long id, String username, String password, String email, Set<Voteit> voteits) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.voteits = voteits;
    }
}
