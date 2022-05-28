package pl.maciejbadziak.voteitbackend.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tag")
@Getter
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    @ManyToMany(mappedBy = "tags")
    private final Set<Voteit> voteits;
    @Column(length = 20, nullable = false)
    private final String name;
    @Builder
    public Tag(Long id, String name, Set<Voteit> voteits) {
        super(id);
        this.name = name;
        this.voteits = voteits;
    }
}
