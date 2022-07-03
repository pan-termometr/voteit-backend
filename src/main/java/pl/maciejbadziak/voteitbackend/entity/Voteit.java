package pl.maciejbadziak.voteitbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Voteit")
@Table(name = "voteits")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Voteit extends BaseEntity {

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "voteits_tags",
            joinColumns = { @JoinColumn(name = "voteit_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    @JsonManagedReference
    private Set<Tag> tags = new HashSet<>();
    @Column(length=100, nullable=false)
    private String title;
    @Column(length=500, nullable=false)
    private String description;
    @Column(length=250, nullable=false)
    private String url;
    @Column(length=250)
    private String thumbnail;
    @Column(nullable=false)
    private int votesUp;
    @Column(nullable=false)
    private int votesDown;
    @Column(nullable=false)
    private boolean isForAdult;
    @Column(nullable=false)
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    @JsonManagedReference
    private User author;
    @Builder
    public Voteit(
            long id,
            Set<Tag> tags,
            String title,
            String description,
            String url,
            String thumbnail,
            int votesUp,
            int votesDown,
            boolean isForAdult,
            LocalDateTime creationDate,
            User author) {
        super(id);
        this.tags = tags;
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumbnail = thumbnail;
        this.votesUp = votesUp;
        this.votesDown = votesDown;
        this.isForAdult = isForAdult;
        this.creationDate = creationDate;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Voteit voteit = (Voteit) o;
        return votesUp == voteit.votesUp && votesDown == voteit.votesDown && isForAdult == voteit.isForAdult && tags.equals(voteit.tags) && title.equals(voteit.title) && description.equals(voteit.description) && url.equals(voteit.url) && Objects.equals(thumbnail, voteit.thumbnail) && creationDate.equals(voteit.creationDate) && author.equals(voteit.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tags, title, description, url, thumbnail, votesUp, votesDown, isForAdult, creationDate, author);
    }
}
