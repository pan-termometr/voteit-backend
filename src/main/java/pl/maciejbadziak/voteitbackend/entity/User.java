package pl.maciejbadziak.voteitbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @OneToMany(mappedBy = "author", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonIgnore
    private Set<Voteit> voteits = new HashSet<>();
    @Column(length=20, nullable=false)
    private String username;
    @Column(length=20, nullable=false)
    private String password;
    @Column(length=30, nullable=false)
    private String email;
    @Builder
    public User(Long id, String username, String password, String email, Set<Voteit> voteits) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.voteits = voteits;
    }
}
