package pl.maciejbadziak.voteitbackend.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Voteit")
@Table(name="voteit")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Voteit extends BaseEntity {

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "voteit_tag",
            joinColumns = { @JoinColumn(name = "tag_id") },
            inverseJoinColumns = { @JoinColumn(name = "voteit_id") }
    )
    private final Set<Tag> tags;
    @Column(length=100, nullable=false)
    private final String title;
    @Column(length=500, nullable=false)
    private final String description;
    @Column(length=250, nullable=false)
    private final String url;
    @Column(length=250)
    private final String picture;
    @Column(nullable=false)
    private final int voteUp;
    @Column(nullable=false)
    private final int voteDown;
    @Column(nullable=false)
    private final boolean isForAdult;
    @Column(nullable=false)
    private final LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private final User author;
    @Builder
    public Voteit(
            long id,
            Set<Tag> tags,
            String title,
            String description,
            String url,
            String picture,
            int voteUp,
            int voteDown,
            boolean isForAdult,
            LocalDateTime creationDate,
            User author) {
        super(id);
        this.tags = tags;
        this.title = title;
        this.description = description;
        this.url = url;
        this.picture = picture;
        this.voteUp = voteUp;
        this.voteDown = voteDown;
        this.isForAdult = isForAdult;
        this.creationDate = creationDate;
        this.author = author;
    }
}
