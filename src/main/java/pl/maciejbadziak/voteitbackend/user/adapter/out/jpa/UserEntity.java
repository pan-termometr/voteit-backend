package pl.maciejbadziak.voteitbackend.user.adapter.out.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa.VoteitEntity;

import java.time.LocalDateTime;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Getter
@Table(name = "app_user")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
