package pl.maciejbadziak.voteitbackend.voteit.adapter.out.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.maciejbadziak.voteitbackend.tag.adapter.out.jpa.TagEntity;
import pl.maciejbadziak.voteitbackend.user.adapter.out.jpa.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "voteit")
public class VoteitEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 80, nullable = false)
    private String title;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @Column(name = "url", length = 2048, nullable = false, unique = true)
    private String url;

    @Column(name = "thumbnail", length = 2048)
    private String thumbnail;

    @Column(name = "votes_up", nullable = false)
    private int votesUp;

    @Column(name = "votes_down", nullable = false)
    private int votesDown;

    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "voteit_tag_x",
            joinColumns = {@JoinColumn(name = "voteit_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    @Column(name = "tags", nullable = false)
    private Set<TagEntity> tags;

    @Column(name = "for_adult_only", nullable = false)
    private boolean isForAdultOnly;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "app_user_id", nullable = false)
    private UserEntity creator;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
}




