package pl.maciejbadziak.voteitbackend.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "Voteit")
@Table(name="voteit")
@Data
@Builder
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
    private Set<Tag> tags;
    @Column(length=100, nullable=false)
    private String title;
    @Column(length=500, nullable=false)
    private String description;
    @Column(length=250, nullable=false)
    private String url;
    @Column(length=250)
    private String picture;
    @Column(nullable=false)
    private int voteUp;
    @Column(nullable=false)
    private int voteDown;
    @Column(nullable=false)
    private boolean isForAdult;
    @Column(nullable=false)
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private User author;
}
