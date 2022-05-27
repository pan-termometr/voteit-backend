package pl.maciejbadziak.voteitbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
public class User extends CommonFields {

    @OneToMany(mappedBy = "author", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    final private Set<Voteit> voteitList = new HashSet<>();
    @Column(length=20, nullable=false)
    private String user;
    @Column(length=20, nullable=false)
    private String password;
    @Column(length=30, nullable=false)
    private String email;
}
