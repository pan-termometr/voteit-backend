package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import lombok.*;
import pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa.VoteitEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Getter
@Setter
@Table(name = "app_user")
public class UserEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username", length=30, nullable=false, unique = true)
    private String username;

    @Column(name = "password", length=128, nullable=false)
    private String password;

    @Column(name = "email", length=320, nullable=false, unique = true)
    private String email;

    @Column(name = "registration_date", nullable=false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "creator", fetch = LAZY)
    private Set<VoteitEntity> voteits;
}
