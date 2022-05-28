package pl.maciejbadziak.voteitbackend.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @OneToMany(mappedBy = "author", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<Voteit> voteits;
    @Column(length=20, nullable=false)
    private String username;
    @Column(length=20, nullable=false)
    private String password;
    @Column(length=30, nullable=false)
    private String email;
}
