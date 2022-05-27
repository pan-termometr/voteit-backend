package pl.maciejbadziak.voteitbackend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Voteit")
@Table(name="voteit")
public class Voteit extends CommonFields {

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "voteit_tag",
            joinColumns = { @JoinColumn(name = "tag_id") },
            inverseJoinColumns = { @JoinColumn(name = "voteit_id") }
    )
    final private Set<Tag> tags = new HashSet<>();
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
