package pl.maciejbadziak.voteitbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @OneToMany(mappedBy = "author", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonBackReference
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, email);
    }
}
